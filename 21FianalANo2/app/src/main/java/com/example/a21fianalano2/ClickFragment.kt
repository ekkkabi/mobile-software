package com.example.a21fianalano2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.a21fianalano2.databinding.FragmentClickBinding
import com.example.a21fianalano2.databinding.FragmentPrintBinding

private lateinit var binding: FragmentClickBinding

class ClickFragment : Fragment() {
    var activityCallback: ClickListener? = null

    interface ClickListener {
        fun onButtonClick1(user: Int, c: Int)
        fun onButtonClick2()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ClickListener) {
                activityCallback = context
            }
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ClickListener()")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClickBinding.inflate(inflater, container, false)

        // 라디오 버튼 설정
        val selectsArr: Array<String> = resources.getStringArray(R.array.selects)
        val radioArr: Array<RadioButton> =
            arrayOf(binding.radioButton1, binding.radioButton2, binding.radioButton3)
        radioArr.forEachIndexed { index, rb ->
            rb.text = selectsArr[index]
        }

        binding.decideBtn.setOnClickListener {
            val range = (0..2)
            val c = range.random()
            val user = radioArr.indexOfFirst { it.isChecked }
            activityCallback?.onButtonClick1(user, c)
        }

        binding.cancelBtn.setOnClickListener {
            activityCallback?.onButtonClick2()
        }

        return binding.root
    }

}