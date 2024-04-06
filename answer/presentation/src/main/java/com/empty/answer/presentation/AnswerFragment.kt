package com.empty.answer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.empty.answer.presentation.databinding.FragmentRequestBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnswerFragment : Fragment() {
    private val answerViewModel: AnswerViewModel by viewModel<AnswerViewModel>()
    private var _binding: FragmentRequestBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        answerViewModel.answerState.onEach {
            binding.tvAnswer.text = it
        }.launchIn(lifecycleScope)
        binding.btSend.setOnClickListener {
            answerViewModel.requestAnswer(binding.edQuestion.text.toString())
        }
    }

}