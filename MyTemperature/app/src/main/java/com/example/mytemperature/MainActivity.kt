package com.example.mytemperature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mytemperature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val inputTemperature = binding.tempEditText.text.toString()
            if (inputTemperature.isNotEmpty()) {
                if (binding.radioCelsius.isChecked) {
                    convertCtoF(inputTemperature.toDouble())
                } else if (binding.radioFahrenheit.isChecked) {
                    convertFtoC(inputTemperature.toDouble())
                } else {
                    convertCtoF(inputTemperature.toDouble())
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "온도를 입력하세요.", Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.button2.setOnClickListener {
            binding.tempEditText.text.clear()
            binding.radioGroup2.clearCheck()
            binding.textView2.visibility = View.INVISIBLE
            binding.radioFahrenheit.isChecked = false
            binding.radioCelsius.isChecked = false
            binding.tempEditText.setText("")
        }
    }

    private fun convertCtoF(C: Double) {
        val C = C
        val F: Double = C * 9 / 5 + 32
        val convertedTemperature = String.format("%.1f", F)
        binding.textView2.visibility = View.VISIBLE
        binding.textView2.text = "섭씨 ${C}[C] -> 화씨 ${convertedTemperature}[F]"
    }

    private fun convertFtoC(F: Double) {
        val F = F
        val C: Double = (F - 32) / 1.8
        val convertedTemperature = String.format("%.1f", C)
        binding.textView2.visibility = View.VISIBLE
        binding.textView2.text = "화씨 ${F}[F] -> 섭씨 ${convertedTemperature}[C]"
    }
}