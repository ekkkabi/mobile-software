package com.example.mycafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.example.mycafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 체크박스 설정
        val menus = resources.getStringArray(R.array.coffee_menus)
        val itemArr: Array<CheckBox> =
            arrayOf(binding.americanoCheckBox, binding.latteCheckBox, binding.decafCheckBox)
        itemArr.forEachIndexed { index, checkBox ->
            checkBox.text = menus[index]
        }

        // 스피너 설정
        val qty: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6)
        val spinnerArr: Array<Spinner> =
            arrayOf(binding.spinner, binding.spinner2, binding.spinner3)

        val adapter: ArrayAdapter<Int> = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_spinner_item, qty
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerArr.forEachIndexed { index, sp ->
            sp.adapter = adapter
        }
        /* 보일러 코드; 위와 같은 코드
        binding.spinner.adapter = adapter
        binding.spinner2.adapter = adapter
        binding.spinner3.adapter = adapter
         */

        // 버튼 이벤트 설정
        binding.selectButton.setOnClickListener {
            var sb = StringBuilder()
            itemArr.forEachIndexed { index, cb ->
                if (cb.isChecked) {
                    sb.append("${cb.text}=${spinnerArr[index].selectedItem}잔 ")
                }
            }
            if (sb.isNotEmpty()) {
                sb.append("are ordered. Thanks!")
                showToast(sb.toString())
            } else {
                sb.append("Nothing selected. Please order again.")
                showToast(sb.toString())
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_LONG
        ).show()
    }
}