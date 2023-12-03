package com.example.myarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myarray.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // 문자열 배열
            val strArr: Array<String> = resources.getStringArray(R.array.colors)
            val s = "원소 개수 = ${strArr.size}, ${strArr[0]}, ${strArr[1]}, ${strArr[2]}"
            binding.textView.text = s

            // 정수 배열
            val intArr: IntArray = resources.getIntArray(R.array.intValues)
            val sb = StringBuilder()
            intArr.forEach { ele -> sb.append("$ele, ") }
            binding.textView.text = sb.toString()


            // 문자열 배열 -> 실수 배열
            val strArr2 : Array<String> = resources.getStringArray(R.array.numericalValue)
            val floatArr : Array<Float> = Array(strArr2.size){i -> strArr2[i].toFloat()}
            floatArr.forEach { ele -> sb.append("$ele, ") }
            binding.textView.text = sb.toString()
        }
    }
}