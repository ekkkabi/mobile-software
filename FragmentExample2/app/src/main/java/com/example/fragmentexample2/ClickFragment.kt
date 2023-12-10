package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample2.CommonDataViewModel
import com.example.fragmentexample2.databinding.FragmentClickBinding


class ClickFragment : Fragment() {
    private val viewModel: CommonDataViewModel by lazy {
        ViewModelProvider(requireActivity()).get(CommonDataViewModel::class.java)
    }
    private var currentCount = 50
    private lateinit var binding: FragmentClickBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.countUpButton.setOnClickListener {
            currentCount += 5
            binding.countTextView.text = "Count = $currentCount"
            viewModel.setCount(currentCount)
        }
        binding.countDownButton.setOnClickListener {
            currentCount -= 5
            binding.countTextView.text = "Count = $currentCount"
            viewModel.setCount(currentCount)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClickBinding.inflate(inflater, container, false)

        return binding.root
    }
}