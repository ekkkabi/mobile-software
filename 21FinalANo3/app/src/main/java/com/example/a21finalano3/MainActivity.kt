package com.example.a21finalano3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.a21finalano3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nums: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textNums: List<TextView> = arrayListOf(
            binding.textView2, binding.textView3, binding.textView4,
            binding.textView5, binding.textView6, binding.textView7,
        )

        binding.button.setOnClickListener {
            updateNum(textNums)
        }

        binding.button2.setOnClickListener {
            var subIntent = Intent(
                this@MainActivity,
                ResultActivity::class.java
            )
            val numsArrayList = ArrayList(nums)
            subIntent.putIntegerArrayListExtra("randomNumbers", numsArrayList)
            startActivity(subIntent)
        }

        // Initialize nums when the activity is created
        nums = generateRandomN()
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
