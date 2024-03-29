package com.empty.request.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val requestModule = module {
    viewModel { RequestViewModel(get()) }
}