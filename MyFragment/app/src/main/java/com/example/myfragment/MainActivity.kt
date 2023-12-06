package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnArr : Array<Button> = arrayOf(binding.btnFragment1, binding.btnFragment2, binding.btnFragment3)
        btnArr.forEachIndexed { index, b ->
            b.setOnClickListener {
                setFrag(index)
            }
        }
    }

    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when (fragNum) {
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit()
            }

            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }

            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit()
            }
        }
    }
}