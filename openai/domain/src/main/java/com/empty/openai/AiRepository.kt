package com.empty.openai

interface AiRepository {
    suspend fun requestAi(question: String): AiModel
}