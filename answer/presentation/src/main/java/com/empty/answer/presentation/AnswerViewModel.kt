package com.empty.answer.presentation

import kotlinx.coroutines.flow.StateFlow

interface AnswerViewModel {
    val answer: StateFlow<AiAnswerUiModel>
    val searchAnswer: StateFlow<SearchResultUiModel>
    fun request(question: String)
}