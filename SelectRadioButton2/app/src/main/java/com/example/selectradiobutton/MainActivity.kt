package com.example.selectradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
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
        val colorRadioArr =
            arrayOf<RadioButton>(binding.radioRed, binding.radioGreen, binding.radioBlue)
        colorRadioArr.forEachIndexed { index, rb: RadioButton ->
            rb.text = colorArr[index]
        }

        when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioRed -> showToast((colorArr[0]))
            R.id.radioGreen -> showToast((colorArr[1]))
            R.id.radioGreen -> showToast((colorArr[2]))
        }

        /*if (colorRadioArr.none { it.isChecked }) {
            showToast("")
        } else {
            colorRadioArr.forEach { rb: RadioButton ->
                if (rb.isChecked)
                    showToast(rb.text.toString())
            }
        }*/

        /* 보일러 코드
        binding.radioRed.text = colorArr[0]
        binding.radioGreen.text = colorArr[1]
        binding.radioBlue.text = colorArr[2]

        when {
            binding.radioRed.isChecked -> showToast(colorArr[0])
            binding.radioGreen.isChecked -> showToast(colorArr[1])
            binding.radioBlue.isChecked -> showToast(colorArr[2])
            else -> showToast("")
        }*/


        val lis = RadioLister()
        // 독립적
        // colorRadioArr.forEach { it.setOnCheckedChangeListener(lis) }
        /*        binding.radioRed.setOnCheckedChangeListener(lis)
                binding.radioGreen.setOnCheckedChangeListener(lis)
                binding.radioBlue.setOnCheckedChangeListener(lis)*/

        // 라디오 그룹으로...
        binding.radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(rg: RadioGroup?, checkedId: Int) {
                val rdButton = findViewById<RadioButton>(checkedId)
                val msg = "${rdButton.text}를 선택했군요."
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

    // 독립적으로 사용시...
    inner class RadioLister : OnCheckedChangeListener {
        override fun onCheckedChanged(cb: CompoundButton?, checked: Boolean) {
            if (cb == null) return
            if (checked) {
                val msg = "${cb.text}를 선택했군요."
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