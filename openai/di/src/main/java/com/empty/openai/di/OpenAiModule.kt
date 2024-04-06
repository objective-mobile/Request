package com.empty.openai.di

import com.empty.core.data.BaseHttpClient
import com.empty.core.data.CoreHttpClient
import com.empty.openai.AiRepository
import com.empty.openai.data.BaseAiRepository
import org.koin.dsl.module

val openAiModule = module {
    factory<AiRepository> {
        BaseAiRepository(get())
    }
    factory<CoreHttpClient> {
        BaseHttpClient("https://api.openai.com/v1/chat/completions", BuildConfig.OPENAI_TOKEN)
    }
}