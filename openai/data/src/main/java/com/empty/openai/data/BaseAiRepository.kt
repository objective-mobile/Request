package com.empty.openai.data

import com.empty.openai.AiModel
import com.empty.openai.AiRepository
import com.empty.openai.data.model.request.AiMessageRequest
import com.empty.openai.data.model.request.AiRequest
import com.empty.openai.data.model.response.AiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class BaseAiRepository(private val httpClient: HttpClient) : AiRepository {
    override suspend fun requestAi(question: String): AiModel {
        return httpClient.post {
            setBody(AiRequest(
                messages = listOf(
                    AiMessageRequest(),
                    AiMessageRequest("user", question)
                )
            ))
        }.body<AiResponse>().toDomainAiModel()
    }
}