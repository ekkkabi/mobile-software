package com.example.fragmentsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentsample2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.ButtonListnerA, FragmentB.ButtonListnerB {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ft: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (ft == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, FragmentA())
                addToBackStack(null)
                commit()
            }
        }

        binding.buttonA.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentA())
                addToBackStack(null)
                commit()
            }
        }

        binding.buttonB.setOnClickListener {
            val fr = FragmentB.newInstance("My passed parameter")
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fr)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onButtonClickA() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, FragmentB())
            addToBackStack(null)
            commit()
        }
    }

    override fun onButtonClickB() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, FragmentA())
            addToBackStack(null)
            commit()
        }
    }
}