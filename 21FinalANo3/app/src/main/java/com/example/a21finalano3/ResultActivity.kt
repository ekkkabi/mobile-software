package com.example.a21finalano3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.a21finalano3.databinding.ActivityMainBinding
import com.example.a21finalano3.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var nums: MutableList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textNums: List<TextView> = arrayListOf(
            binding.textView9, binding.textView10, binding.textView11,
            binding.textView12, binding.textView13, binding.textView14,
        )
        updateNum(textNums)

    }

    private fun updateNum(textNums: List<TextView>) {
        nums = generateRandomN()
        textNums.forEachIndexed { index, tv ->
            tv.text = nums[index].toString()
        }
    }

    private fun generateRandomN(): MutableList<Int> {
        val generatedNums = mutableListOf<Int>()
        while (generatedNums.size < 6) {
            val randomNumber = (1..45).random()
            if (randomNumber !in generatedNums)
                generatedNums.add(randomNumber)
        }
        return generatedNums.sorted().toMutableList()
    }
}