package com.example.a21midno2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.a21midno2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var desText: TextView = binding.desTextView
        binding.nightImageView.setOnClickListener {
            if (desText.visibility == View.INVISIBLE) {
                desText.visibility = View.VISIBLE
            } else {
                desText.visibility = View.INVISIBLE
            }
        }
    }
}