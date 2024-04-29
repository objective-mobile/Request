package com.empty.answer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Card
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
            Text(text = answer)
            LazyColumn {
                items(answerSearch) {
                    Card(
                        Modifier
                            .fillParentMaxWidth()
                            .padding(8.dp, 4.dp)) {
                        Text(text = it)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAnswerUi() {
    AnswerUi(viewModel = object : AnswerViewModel {
        override val answer: StateFlow<String>
            get() = MutableStateFlow("Test answer")
        override val searchAnswer: StateFlow<List<String>>
            get() = MutableStateFlow(listOf())

        override fun request(question: String) {
        }
    })
}