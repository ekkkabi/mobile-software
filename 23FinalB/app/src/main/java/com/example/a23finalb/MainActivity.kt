package com.example.a23finalb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a23finalb.databinding.ActivityMainBinding
import com.example.`23FinalB`.FragmentA
import com.example.`23FinalB`.FragmentB

class MainActivity : AppCompatActivity(), FragmentA.ClickLisner {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick(rb: Int, sp: Long, sp2:Long) {
        val fragmentB =
            supportFragmentManager.findFragmentById(R.id.fragmentB)
                    as FragmentB
        fragmentB.showRst(rb, sp, sp2)
    }
}