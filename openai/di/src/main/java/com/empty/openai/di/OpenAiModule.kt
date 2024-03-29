package com.empty.openai.di

import com.empty.openai.AiRepository
import com.empty.openai.data.BaseAiRepository
import com.empty.openai.data.BaseHttpClient
import com.empty.openai.data.CoreHttpClient
import org.koin.dsl.module

val openAiModule = module {
    factory<AiRepository> {
        BaseAiRepository(get())
    }
    factory<CoreHttpClient> {
        BaseHttpClient()
    }
}