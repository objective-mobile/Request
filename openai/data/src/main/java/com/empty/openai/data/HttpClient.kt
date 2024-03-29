package com.empty.openai.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson


interface CoreHttpClient {
    fun httpClient(): HttpClient
}

class BaseHttpClient : CoreHttpClient {

    private val httpClient: HttpClient by lazy {
        HttpClient {
            expectSuccess = true
            defaultRequest {
                url("https://api.openai.com/v1/chat/completions")
                contentType(ContentType.Application.Json)
            }
            install(Logging) {
                logger = object : io.ktor.client.plugins.logging.Logger {
                    override fun log(message: String) {
                        Log.d("HTTP_CALL_LOGGER", message)
                    }
                }
                level = LogLevel.ALL
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            BuildConfig.OPENAI_TOKEN,
                            BuildConfig.OPENAI_TOKEN
                        )
                    }
                }
            }
            install(ContentNegotiation) {
                gson {
                }
            }
        }
    }

    override fun httpClient() = httpClient
}