package com.empty.search.data

import com.empty.core.data.CoreHttpClient
import com.empty.search.data.response.SearchResponse
import com.empty.search.domain.SearchAnswerModel
import com.empty.search.domain.SearchRepository
import io.ktor.client.call.body
import io.ktor.client.request.get

class BaseSearchRepository(private val httpClient: CoreHttpClient) : SearchRepository {
    override suspend fun request(query: String): List<SearchAnswerModel> {
        return httpClient.httpClient().get {
            url {
                parameters.append("q", query)
            }
        }.body<SearchResponse>().items.map { it.toSearchAnswer() }
    }
}