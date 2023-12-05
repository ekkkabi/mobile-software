package com.example.intentsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intentsample.databinding.ActivityMainBinding

const val MY_STRING = "my_string"
const val MY_INT = "my_int"
const val RETURN_MESSAGE = "com.example.intent sample.RETURN_MESSAGE"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            val str = binding.editText.text.toString()
            intent.putExtra(MY_STRING, str)
            intent.putExtra(MY_INT, 13)
            startForResult.launch(intent)
        }
    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        object : ActivityResultCallback<ActivityResult> {
            override fun onActivityResult(result: ActivityResult?) {
                if (result?.resultCode == Activity.RESULT_OK) {
                    if (result.data != null) {
                        val extras: Bundle? = result.data!!.extras
                        val returnStr =
                            extras?.getString(RETURN_MESSAGE) ?: ""
                        binding.editText.setText(returnStr)
                    }
                }
            }
        }
    )
}
