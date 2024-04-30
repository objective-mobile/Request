@file:OptIn(ExperimentalGlideComposeApi::class)

package com.empty.answer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun AnswerUi(viewModel: AnswerViewModel) {
    val answer by viewModel.answer.collectAsState()
    val answerSearch by viewModel.searchAnswer.collectAsState()
    val textValue = remember {
        mutableStateOf(TextFieldValue())
    }
    MaterialTheme {
        Column {
            Row(Modifier.padding(4.dp)) {
                TextField(value = textValue.value.text, onValueChange = {
                    textValue.value = TextFieldValue(it)
                })
                Modifier.size(8.dp)
                Button(onClick = {
                    viewModel.request(textValue.value.text)
                }) {
                    Text(text = "send")
                }
            }
            Spacer(modifier = Modifier.size(8.dp))
            answer.Show()
            answerSearch.Show()
        }
    }
}

@Preview
@Composable
fun PreviewAnswerUi() {
    AnswerUi(viewModel = object : AnswerViewModel {
        override val answer: StateFlow<AiAnswerUiModel>
            get() = MutableStateFlow(AiAnswerUiModel(""))
        override val searchAnswer: StateFlow<SearchResultUiModel>
            get() = MutableStateFlow(SearchResultUiModel(listOf()))

        override fun request(question: String) {
        }
    })
}