package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentexample.databinding.ActivityMainBinding

const val Key_COUNT = "keyCount"

class MainActivity : AppCompatActivity(), ClickFragment.ClickLister {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick(cnt: Int) {
        val progressFragment =
            supportFragmentManager.findFragmentById(R.id.progress_fragment) as ProgressFragment
        var bundle = Bundle()
        bundle.putInt(Key_COUNT, cnt)
        progressFragment.arguments = bundle
        progressFragment.changeProgressBar(cnt)
    }
}