package com.example.selectspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import com.example.selectspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val planets = resources.getStringArray(R.array.planets_array)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item, planets
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item,
        )
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = SpinnerListner()
    }

    inner class SpinnerListner : AdapterView.OnItemSelectedListener {
        val planetID: Array<Int> = arrayOf(
            R.drawable.mercury, R.drawable.venus, R.drawable.earth,
            R.drawable.mars, R.drawable.jupiter, R.drawable.saturn,
            R.drawable.uranus, R.drawable.neptune,
        )

        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            val planet: String = parent?.getItemAtPosition(position).toString()
            binding.imageView.setImageResource(planetID[position])
            Toast.makeText(
                parent?.context,
                "선택된 행성은 $planet",
                Toast.LENGTH_LONG
            ).show()
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}