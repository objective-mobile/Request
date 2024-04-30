package com.empty.answer.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empty.openai.AiModel
import com.empty.openai.AiRepository
import com.empty.search.domain.SearchAnswerModel
import com.empty.search.domain.SearchRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BaseAnswerViewModel(
    private val aiRepository: AiRepository, private val searchRepository: SearchRepository
) : ViewModel(), AnswerViewModel {
    private val mutableAnswer = MutableStateFlow(AiAnswerUiModel(""))
    private val mutableSearchAnswer = MutableStateFlow(SearchResultUiModel(listOf()))
    override val answer: StateFlow<AiAnswerUiModel>
        get() = mutableAnswer
    override val searchAnswer: StateFlow<SearchResultUiModel>
        get() = mutableSearchAnswer

    override fun request(question: String) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { e, t ->
            Log.d("RequestViewModel", "requestAnswer: ${t.message}")
        }) {
            mutableAnswer.emit(
                aiRepository.requestAi(question).map(object : AiModel.Mapper<AiAnswerUiModel> {
                    override fun map(answer: String) = AiAnswerUiModel(answer)
                })
            )
            mutableSearchAnswer.emit(SearchResultUiModel(searchRepository.request(question).map {
                it.map(object : SearchAnswerModel.Mapper<SearchItemUiModel> {
                    override fun map(
                        title: String,
                        iconUrl: String,
                        shortLink: String,
                        realLink: String,
                        text: String
                    ) = SearchItemUiModel(
                        title, iconUrl, shortLink, realLink, text
                    )
                })
            }))
        }
    }
}