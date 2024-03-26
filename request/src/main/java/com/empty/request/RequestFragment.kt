package com.empty.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.empty.request.databinding.FragmentRequestBinding
import kotlinx.coroutines.flow.onEach

class RequestFragment : Fragment() {
    private lateinit var requestViewModel: RequestViewModel
    private var _binding: FragmentRequestBinding? = null
    private val binding = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRequestBinding.inflate(inflater, container, true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestViewModel.answerState.onEach {
            binding.tvAnswer.text = it
        }
        binding.btSend.setOnClickListener {
            requestViewModel.requestAnswer(binding.edQuestion.text.toString())
        }
    }

}