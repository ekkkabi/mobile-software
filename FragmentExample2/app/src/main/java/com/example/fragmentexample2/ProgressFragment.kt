package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentexample2.CommonDataViewModel
import com.example.fragmentexample2.databinding.FragmentProgressBinding


class ProgressFragment : Fragment() {
    private lateinit var binding: FragmentProgressBinding
    private val viewModel: CommonDataViewModel by lazy {
        ViewModelProvider(requireActivity()).get(CommonDataViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val myObserver = object : Observer<Int> {
            override fun onChanged(cnt: Int) {
                if (cnt in 1..100) {
                    binding.progressBar.progress = cnt
                    binding.ratingBar.rating = cnt / 20f
                } else {
                    binding.progressBar.progress = 50
                    binding.ratingBar.rating = 2.5f
                }
            }
        }
        viewModel.myCount.observe(
            viewLifecycleOwner, myObserver
        )

    }
}