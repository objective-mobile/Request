package com.empty.openai.data.model.request
data class AiRequest(
    private val model: String = "gpt-3.5-turbo",
    private val messages: List<AiMessageRequest>
)