package com.example.eventhandler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eventhandler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.textView.text = getString(R.string.text_message)
//        binding.textView.text = "안녕, 안드로이드!"
        }

    }
}