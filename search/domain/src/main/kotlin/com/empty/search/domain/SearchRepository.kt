package com.empty.search.domain

interface SearchRepository {
    suspend fun request(query: String): List<SearchAnswerModel>
}