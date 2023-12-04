package com.example.myonlinepoll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myonlinepoll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cakesArr : Array<String> = resources.getStringArray(R.array.version_list)
        val cakesRadioArr = arrayOf(binding.radioButton, binding.radioButton2, binding.radioButton3)
        val imgArr = arrayOf(R.drawable.queencake, R.drawable.redvelvetcake, R.drawable.snowcone)

        // 라디오 버튼에 텍스트 설정
        cakesRadioArr.forEachIndexed { index, rb ->
            rb.text = cakesArr[index]
        }

        // 라디오 버튼 선택 시 이미지 표시
        cakesRadioArr.forEachIndexed { index, rb ->
            if(rb.isChecked){
                binding.imageView.visibility = View.VISIBLE
                binding.imageView.setImageResource(imgArr[index])
            }
        }

        binding.button.setOnClickListener {
            binding.imageView.visibility = View.VISIBLE
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButton -> binding.imageView.setImageResource(R.drawable.queencake)
                R.id.radioButton2 -> binding.imageView.setImageResource(R.drawable.redvelvetcake)
                R.id.radioButton3 -> binding.imageView.setImageResource(R.drawable.snowcone)
                else -> binding.imageView.visibility = View.INVISIBLE
            }
        }
    }
}