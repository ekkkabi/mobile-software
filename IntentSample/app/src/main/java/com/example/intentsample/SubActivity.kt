package com.example.intentsample

import android.os.Build.VERSION_CODES.M
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentsample.databinding.ActivityMainBinding
import com.example.intentsample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras == null || intent == null) return
        /*
         val qString: String? = intent.getStringExtra(MY_STRING)
         val qInt: Int = intent.getIntExtra(MY_INT, 0)
         binding.editText.setText(qString + qInt.toString())
        */
        if(intent.hasExtra(MY_STRING) && intent.hasExtra(MY_INT))
        {
            val extras: Bundle? = intent.extras
            val qString = extras?.getString(MY_STRING)
            val qInt = extras?.getInt(MY_INT)
            binding.editText.setText("$qString $qInt")
        }

        binding.button.setOnClickListener {
            finish()
        }
    }
}