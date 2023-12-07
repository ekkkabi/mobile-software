package com.example.fragmentexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexample.databinding.FragmentClickBinding
import kotlin.ClassCastException

class ClickFragment : Fragment() {
    interface ClickLister {
        fun onButtonClick(cnt: Int)
    }

    private var activityCallback: ClickLister? = null
    private var currentCount = 50

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ClickLister) {
                activityCallback = context
            }
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ClickListner")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentClickBinding.inflate(inflater, container, false)
        binding.countUpButton.setOnClickListener {
            currentCount += 5
            binding.countTextView.text = "Current $currentCount"
            activityCallback?.onButtonClick(currentCount)
        }
        binding.countDownButton.setOnClickListener {
            currentCount -= 5
            binding.countTextView.text = "Current $currentCount"
            activityCallback?.onButtonClick(currentCount)
        }

        return binding.root
    }
}