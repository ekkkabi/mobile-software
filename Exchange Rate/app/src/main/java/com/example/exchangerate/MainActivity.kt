package com.example.exchangerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import com.example.exchangerate.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wonEditText.setOnEditorActionListener(
            TextView.OnEditorActionListener { v, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    doExchangeCurrency(v?.text.toString())
                    return@OnEditorActionListener true
                }
                false
            }
        )

        binding.convertButton.setOnClickListener {
            doExchangeCurrency(binding.wonEditText.text?.trim().toString())
            doExchangeCurrency(binding.wonTextInputEditText.text?.trim().toString())
        }
    }

    private fun doExchangeCurrency(valueStr: String) {
        if (valueStr.isBlank()) {
            Toast.makeText(
                applicationContext,
                "금액을 입력하세요.",
                Toast.LENGTH_LONG
            ).show()
        } else {
            val bgColor = getColor(R.color.color_background)
            binding.viewgroupScreen.setBackgroundColor(bgColor)

            val color = getColor(R.color.color_textview)
            val textSizeDP = resources.getDimension(R.dimen.textview_size)

            val wonValue: Double = valueStr.toDouble()
            binding.wonEditText.setText("$wonValue 원")
            val rate = resources.getString(R.string.exchange_rate).toDouble()
            val dollarValue = round(wonValue * 10 / rate.toDouble()) / 10
//            val dollarValue : Double = wonValue.toDouble() / rate.toDouble()
//            val resultString = "환전 금액(달러):\n $${dollarValue}"
            binding.amountTextView.text = String.format("%.1f", dollarValue)
        }
    }
}