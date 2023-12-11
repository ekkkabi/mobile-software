package com.example.a21fianalano2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.a21fianalano2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickFragment.ClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick1(user: Int, c: Int) {
        val printFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3)
                    as PrintFragment
        printFragment.changeStr1(user, c)
    }

    override fun onButtonClick2() {
        val printFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3)
                    as PrintFragment
        printFragment.changeStr2()

    }
}