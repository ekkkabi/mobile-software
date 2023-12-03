package com.example.selectcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.selectcheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coffeeArr: Array<String> = resources.getStringArray(R.array.coffee_menus)
        val orderList: Array<CheckBox> =
            arrayOf(binding.americanoCheckBox, binding.latteCheckBox, binding.decafCheckBox)

        orderList.forEachIndexed { index, cb ->
            cb.text = coffeeArr[index]
        }

        binding.selectButton.setOnClickListener {
            var sb = StringBuilder()
            var anyCheckBoxChecked = false

            orderList.forEach {
                if (it.isChecked) {
                    sb.append("${it.text}, ")
                    anyCheckBoxChecked = true
                }
            }
            if (anyCheckBoxChecked) {
                sb.append(" are ordered. Thanks!")
                Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    applicationContext, "Nothing selected. Please order\n" +
                            "again ", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}