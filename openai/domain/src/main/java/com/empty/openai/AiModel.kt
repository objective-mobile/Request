package com.empty.openai

interface AiModel {
    fun <T> map(mapper: AiModel.Mapper<T>): T

    interface Mapper<T>{
        fun map(answer: String): T
    }
}