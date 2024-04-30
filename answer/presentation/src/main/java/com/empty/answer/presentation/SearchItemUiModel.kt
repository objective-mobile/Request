package com.empty.answer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

data class SearchItemUiModel(
    private val title: String,
    private val iconUrl: String,
    private val shortLink: String,
    private val realLink: String,
    private val text: String
) {
    @ExperimentalGlideComposeApi
    @Composable
    fun Show() {
        Card(
            Modifier.padding(8.dp, 4.dp)
        ) {
            Row {
                GlideImage(
                    model = iconUrl,
                    contentDescription = "icon",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(64.dp),
                )
                Column {
                    Text(text = title)
                    Text(text = shortLink)
                    Text(text = text)
                }
            }
        }
    }
}