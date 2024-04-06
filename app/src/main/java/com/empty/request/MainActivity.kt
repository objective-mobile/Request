package com.empty.request

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.empty.answer.presentation.AnswerFragment
import com.empty.request.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.commit {
            replace<AnswerFragment>(R.id.fragment_container)
            setReorderingAllowed(true)
            addToBackStack(AnswerFragment::class.simpleName)
        }
        setContentView(binding.root)
    }
}