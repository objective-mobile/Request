package com.empty.answer.presentation

import kotlinx.coroutines.flow.StateFlow

interface AnswerViewModel {
    val answer: StateFlow<String>
    val searchAnswer: StateFlow<List<String>>
    fun request(question: String)
}