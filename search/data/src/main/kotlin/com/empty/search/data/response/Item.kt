package com.empty.search.data.response

import com.empty.search.data.BaseSearchAnswerModel

data class Item(
    val title: String,
    val link: String,
    val displayLink: String,
    val snippet: String,
) {
    fun toSearchAnswer() = BaseSearchAnswerModel(link)
}