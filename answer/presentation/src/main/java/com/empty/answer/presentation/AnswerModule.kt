package com.empty.answer.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val requestModule = module {
    viewModel { BaseAnswerViewModel(get(), get()) }
}