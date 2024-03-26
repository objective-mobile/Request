package com.empty.openai.data.model.response

import com.empty.openai.data.model.BaseAiModel

data class AiResponse(
    private val choices: List<AiResponseChoice>
){
    fun toDomainAiModel() =
        BaseAiModel(choices.first().answer())
}