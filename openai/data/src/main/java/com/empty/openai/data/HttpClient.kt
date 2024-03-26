package com.empty.openai.data

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.logging.Logger
import kotlinx.serialization.json.Json

object HttpClient {
    fun httpClient() =
        HttpClient{
            expectSuccess = true
            defaultRequest {
                url("https://api.openai.com/v1/chat/completions")
                contentType(ContentType.Application.Json)
            }
            install(Logging)
            install(Auth){
                bearer {
                    loadTokens {
                        BearerTokens("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",
                            "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")
                    }
                }
            }
            install(ContentNegotiation) {
                gson{
                }
            }
        }
}