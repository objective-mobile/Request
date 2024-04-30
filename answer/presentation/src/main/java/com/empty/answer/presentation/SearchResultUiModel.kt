package com.empty.answer.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi

data class SearchResultUiModel(private val list: List<SearchItemUiModel>) {
    @ExperimentalGlideComposeApi
    @Composable
    fun Show() {
        LazyColumn {
            items(list) {
                it.Show()
            }
        }
    }
}