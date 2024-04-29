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
    private val mutableAnswer = MutableStateFlow("")
    private val mutableSearchAnswer = MutableStateFlow<List<String>>(listOf())
    override val answer: StateFlow<String>
        get() = mutableAnswer
    override val searchAnswer: StateFlow<List<String>>
        get() = mutableSearchAnswer

    override fun request(question: String) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { e, t ->
            Log.d("RequestViewModel", "requestAnswer: ${t.message}")
        }) {
            mutableAnswer.emit(
                aiRepository.requestAi(question).map(object : AiModel.Mapper<String> {
                        override fun map(answer: String) = answer
                    })
            )
            mutableSearchAnswer.emit(searchRepository.request(question).map {
                it.map(object : SearchAnswerModel.Mapper<String> {
                    override fun map(answer: String) = answer
                })
            })
        }
    }
}