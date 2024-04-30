package com.empty.search.data.response

import com.empty.search.data.BaseSearchAnswerModel

data class Item(
    val title: String,
    val link: String,
    val displayLink: String,
    val snippet: String, val pagemap: Pagemap?
) {
    fun toSearchAnswer() = BaseSearchAnswerModel(
        title, pagemap?.cse_image?.first()?.src ?: "", displayLink, link, snippet
    )
}

data class Pagemap(
    val cse_image: List<Cseimage>?
)

data class Cseimage(
    val src: String?
)