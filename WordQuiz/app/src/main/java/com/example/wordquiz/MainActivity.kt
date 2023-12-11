package com.example.wordquiz

import android.icu.lang.UCharacter.WordBreak
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.wordquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this).get(WordViewModel::class.java)
    }

    private lateinit var radioArr: Array<RadioButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        radioArr = arrayOf(
            binding.radioButton1,
            binding.radioButton2,
            binding.radioButton3,
            binding.radioButton4
        )

        updateWordQuiz()

        // 문제 이동
        binding.prevButton.setOnClickListener {
            wordViewModel.moveToPrevious()
            updateWordQuiz()
        }

        binding.nextButton.setOnClickListener {
            wordViewModel.moveToNext()
            updateWordQuiz()
        }

        radioArr.forEachIndexed { index, rb ->
            rb.setOnCheckedChangeListener { _, b ->
                if (b) checkAnswer(index + 1)
            }
        }
    }

    // 문제 업데이트
    private fun updateWordQuiz() {
        binding.wordTextView.text = wordViewModel.curQuestion
        radioArr.forEachIndexed { i, rb ->
            rb.text = wordViewModel.curNumbers[i]
        }
        radioArr.forEach {
            it.isChecked = false
        }
    }

    // 정답 확인
    private fun checkAnswer(userAns: Int) {
        val ans: Int = wordViewModel.curAnswer
        val msg =
            if (userAns == ans)
                "정답입니다."
            else
                "오답입니다."
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }


}