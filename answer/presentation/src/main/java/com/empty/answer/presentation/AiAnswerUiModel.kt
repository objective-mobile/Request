package com.empty.answer.presentation

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class AiAnswerUiModel(
    private val answer: String
) {
    @Composable
    fun Show() {
        Card {
            Text(text = answer)
        }
    }
}