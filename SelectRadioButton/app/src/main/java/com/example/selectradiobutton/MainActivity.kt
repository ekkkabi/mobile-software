package com.example.selectradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.selectradiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorArr: Array<String> = resources.getStringArray(R.array.colors)
        val colorRadioArray =
            arrayOf<RadioButton>(binding.radioRed, binding.radioGreen, binding.radioBlue)
        colorRadioArray.forEachIndexed { idx: Int, rb: RadioButton -> rb.text = colorArr[idx] }

        /*
             binding.radioRed.text = colorArr[0]
             binding.radioGreen.text = colorArr[1]
             binding.radioBlue.text = colorArr[2]*/

        /*        if (colorRadioArray.none { it.isChecked }) {
                    showToast("")
                } else {
                    colorRadioArray.forEach { if (it.isChecked) showToast(it.text.toString()) }
                }*/

        /*        when {
                    binding.radioRed.isChecked -> showToast(colorArr[0])
                    binding.radioGreen.isChecked -> showToast(colorArr[1])
                    binding.radioBlue.isChecked -> showToast(colorArr[2])
                    else -> showToast("")
                }*/

        when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioRed -> showToast(colorArr[0])
            R.id.radioGreen -> showToast(colorArr[1])
            R.id.radioBlue -> showToast(colorArr[2])
            else -> showToast("")
        }

        val lis = RadioListner()
        binding.radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(rg: RadioGroup?, checkedId: Int) {
                val rdButton = findViewById<RadioButton>(checkedId)
                val msg = "${rdButton.text} 를 선택했군요!"
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        })
//        colorRadioArray.forEach { it.setOnCheckedChangeListener(lis) }

    }

    inner class RadioListner : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(cb: CompoundButton?, checked: Boolean) {
            if (cb == null) return
            if (checked) {
                val msg = "${cb.text} 를 선택했군요!"
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showToast(str: String) {
        var msg = if (str.isNotEmpty()) {
            "$str 이 기본 선택되어 있습니다."
        } else {
            "아무 것도 선택되어 있지 않습니다."
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}