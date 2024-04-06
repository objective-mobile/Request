package com.empty.search.data

import com.empty.search.domain.SearchAnswerModel

data class BaseSearchAnswerModel(
    private val link: String
) : SearchAnswerModel {
    override fun <T> map(mapper: SearchAnswerModel.Mapper<T>): T {
        return mapper.map(link)
    }
}