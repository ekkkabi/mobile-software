package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.text1.setText("Hi, Kotlin?!")

        binding.button.setOnClickListener {
            var putT = binding.editTextText.text.toString()
            binding.text1.setText(putT)
        }

        binding.button2.setOnClickListener {
            // 다음 화면 이동위한 인텐트 객체 생성
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("msg", binding.text1.text.toString())
            startActivity(intent)
            finish()
        }

        binding.button3.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.chip_dale__sunflowwer)
            Toast.makeText(this@MainActivity, "칩앤데일입니당!", Toast.LENGTH_SHORT).show()
        }

    }
}