package com.example.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentsample.databinding.ActivityMainBinding

const val MY_STRING = "my_string"
const val MY_INT = "my_int"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            val str = binding.editText.text.toString()
            intent.putExtra(MY_STRING, str)
            intent.putExtra(MY_INT, 13)
            startActivity(intent)
            finish()
        }


    }
}