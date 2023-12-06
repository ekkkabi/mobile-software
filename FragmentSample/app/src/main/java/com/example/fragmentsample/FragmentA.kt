package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsample.databinding.FragmentABinding

class FragmentA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentABinding.inflate(inflater, container, false)
        // 여기서 binding 을 이용해 (지역)변수들 이용가능!
        return binding.root
    }
}