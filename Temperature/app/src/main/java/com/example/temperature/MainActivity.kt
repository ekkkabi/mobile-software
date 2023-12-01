package com.example.temperature

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.temperature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val inputTemperature: String = binding.tempEditText.text.toString()

            if (inputTemperature.isNotEmpty()) {
                val temperature: Double = inputTemperature.toDouble()
                val Fah: Double
                val Cel: Double
                if (binding.radioCelsius.isChecked) {
                    val Cel: Double = temperature
                    val Fah: Double = (Cel * 1.8) + 32
                    binding.textView2.text = getString(
                        R.string.result_format,
                        "썹씨",
                        String.format("%.1f", Cel),
                        "[C]"
                    ) +
                            " -> " +
                            getString(
                                R.string.result_format,
                                "화씨",
                                String.format("%.1f", Fah),
                                "[F]"
                            )
                } else if (binding.radioFahrenheit.isChecked) {
                    val Fah: Double = temperature
                    val Cel: Double = (Fah - 32) * 1.8
                    binding.textView2.text = getString(
                        R.string.result_format,
                        "화씨",
                        String.format("%.1f", Fah),
                        "[F]"
                    ) +
                            " -> " +
                            getString(
                                R.string.result_format,
                                "썹씨",
                                String.format("%.1f", Cel),
                                "[C]"
                            )
                }
                binding.textView2.visibility = View.VISIBLE
            } else {
                Toast.makeText(
                    applicationContext, "온도를 입력하세요",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.button2.setOnClickListener {
            binding.tempEditText.text.clear()
            binding.radioGroup.clearCheck()
            binding.textView2.visibility = View.INVISIBLE
        }
    }
}