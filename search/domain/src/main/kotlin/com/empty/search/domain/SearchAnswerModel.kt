package com.empty.search.domain

interface SearchAnswerModel {
    fun <T> map(mapper: Mapper<T>): T
    interface Mapper<T> {
        fun map(
            title: String, iconUrl: String, shortLink: String, realLink: String, text: String
        ): T
    }
}