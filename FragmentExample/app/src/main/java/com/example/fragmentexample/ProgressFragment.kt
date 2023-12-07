package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexample.databinding.FragmentProgressBinding

class ProgressFragment : Fragment() {
    private lateinit var binding: FragmentProgressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeProgressBar(cnt: Int) {
        if (cnt in 1..100) {
            binding.progressBar.progress = cnt
            binding.ratingBar.rating = cnt / 20f
        } else {
            binding.progressBar.progress = 50
            binding.ratingBar.rating = 2.5f
        }
    }

}