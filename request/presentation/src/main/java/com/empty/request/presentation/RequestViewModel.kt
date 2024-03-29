package com.empty.request.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.empty.openai.AiModel
import com.empty.openai.AiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RequestViewModel(
    private val aiRepository: AiRepository
) : ViewModel() {
    private val mutableAnswer = MutableStateFlow("")
    val answerState = mutableAnswer.asStateFlow()
    fun requestAnswer(question: String) {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { e, t ->
            Log.d("RequestViewModel", "requestAnswer: ${t.message}")
        }) {
            mutableAnswer.emit(aiRepository.requestAi(question).map(
                object : AiModel.Mapper<String> {
                    override fun map(answer: String) = answer
                }
            ))
        }
    }

}