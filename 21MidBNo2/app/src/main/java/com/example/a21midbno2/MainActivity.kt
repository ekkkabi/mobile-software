package com.example.a21midbno2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.example.a21midbno2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 먼 훗날 본문 클릭 -> 오른쪽으로 한줄로 스크롤 되도록 읽기
        binding.textView3.setOnTouchListener { view, _ ->
            (view as TextView).isSingleLine = true
            (view as TextView).ellipsize = TextUtils.TruncateAt.MARQUEE
            view.isSelected = true
            true
        }
    }
}