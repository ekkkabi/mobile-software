package com.example.fragmentsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.ButtonListener, FragmentB.ButtonListenerB {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fr: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        // 초기 화면 설정
        if (fr == null) {
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
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FragmentB())
                addToBackStack(null)
                commit()
            }
        }

    }

    override fun onButtonClick() {
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