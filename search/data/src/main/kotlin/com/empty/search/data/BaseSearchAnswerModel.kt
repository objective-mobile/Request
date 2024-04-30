package com.empty.search.data

import com.empty.search.domain.SearchAnswerModel

data class BaseSearchAnswerModel(
    private val title: String,
    private val iconUrl: String,
    private val shortLink: String,
    private val realLink: String,
    private val text: String
) : SearchAnswerModel {
    override fun <T> map(mapper: SearchAnswerModel.Mapper<T>): T {
        return mapper.map(
            title, iconUrl, shortLink, realLink, text
        )
    }
}