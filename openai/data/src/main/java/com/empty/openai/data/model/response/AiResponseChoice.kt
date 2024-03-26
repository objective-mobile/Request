package com.empty.openai.data.model.response
data class AiResponseChoice(
    private val message: AiResponseMessage
){
    fun answer() = message.answer()
}
data class AiResponseMessage(
    private val content: String
){
    fun answer() = content
}