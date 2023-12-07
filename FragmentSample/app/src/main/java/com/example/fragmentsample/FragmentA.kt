package com.example.fragmentsample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsample.databinding.FragmentABinding

class FragmentA : Fragment() {
    interface ButtonListener {
        fun onButtonClick()
    }

    var activityCallback: ButtonListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ButtonListener) {
                activityCallback = context
            }
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ButtonListner")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentABinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            activityCallback?.onButtonClick()
        }
        // 여기서 binding 을 이용해 (지역)변수들 이용가능!
        return binding.root
    }
}