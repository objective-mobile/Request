package com.empty.request.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.empty.request.presentation.databinding.FragmentRequestBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class RequestFragment : Fragment() {
    private val requestViewModel: RequestViewModel by viewModel<RequestViewModel>()
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
        requestViewModel.answerState.onEach {
            binding.tvAnswer.text = it
        }.launchIn(lifecycleScope)
        binding.btSend.setOnClickListener {
            requestViewModel.requestAnswer(binding.edQuestion.text.toString())
        }
    }

}