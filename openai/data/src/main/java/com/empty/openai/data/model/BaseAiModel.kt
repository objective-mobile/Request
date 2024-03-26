package com.empty.openai.data.model

import com.empty.openai.AiModel

class BaseAiModel(
    private val answer: String
) : AiModel {
    override fun <T> map(mapper: AiModel.Mapper<T>) =
        mapper.map(answer)
}