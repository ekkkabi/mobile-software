package com.example.eventhandler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventhandler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            binding.textView.text = "Button Clicked"
            Toast.makeText(
                applicationContext,
                "Toast ; Btn Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.button5.setOnLongClickListener {
            binding.textView.text = "Long Button Clicked"
            Toast.makeText(
                applicationContext,
                "Toast ; Long Btn Clicked",
                Toast.LENGTH_SHORT
            ).show()
            false
        }


    }
}