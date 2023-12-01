package com.example.cafe

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.temperature.R
import com.example.temperature.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu = resources.getStringArray(R.array.quantaty)
        val quantity = resources.getStringArray(R.array.quantaty)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item, quantity
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spinner.adapter = adapter
        binding.spinner.setSelection(0)

        var sb = StringBuilder()
        if (binding.americanoCheckBox.isChecked) {
            sb.append("(${menu[0]}=$quantity 잔) ")
        }
        if (binding.latteCheckBox.isChecked) {
            sb.append("(${menu[1]}=$quantity 잔) ")
        }
        if (binding.decafCheckBox.isChecked) {
            sb.append("(${menu[2]}=$quantity 잔) ")
        }

        if (sb.isNotEmpty()) {
            sb.append(" are ordered. Thanks!")
        } else {
            sb.append("Nothing selected. Please order again.")
        }

        Toast.makeText(
            applicationContext, sb.toString(),
            Toast.LENGTH_LONG
        ).show()
    }
}

