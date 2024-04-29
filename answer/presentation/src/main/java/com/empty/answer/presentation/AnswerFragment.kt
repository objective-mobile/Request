package com.empty.answer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

import org.koin.androidx.viewmodel.ext.android.viewModel

class AnswerFragment : Fragment() {
    private val baseAnswerViewModel: BaseAnswerViewModel by viewModel<BaseAnswerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AnswerUi(viewModel = baseAnswerViewModel)
            }
        }
    }

}