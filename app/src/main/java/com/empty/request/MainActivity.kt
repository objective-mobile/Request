package com.empty.request

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.empty.request.databinding.ActivityMainBinding
import com.empty.request.presentation.RequestFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.commit {
            replace<RequestFragment>(R.id.fragment_container)
            setReorderingAllowed(true)
            addToBackStack(RequestFragment::class.simpleName)
        }
        setContentView(binding.root)
    }
}