package com.empty.openai.data.model.request

data class AiMessageRequest(
   private val role: String = "system",
   private val content: String = "You are a search assistant."
)