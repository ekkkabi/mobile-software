package com.example.fragmentsample2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsample2.databinding.FragmentABinding
import com.example.fragmentsample2.databinding.FragmentBBinding


class FragmentA : Fragment() {
    interface ButtonListnerA {
        fun onButtonClickA()
    }

    private var activityCallback: ButtonListnerA? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ButtonListnerA)
                activityCallback = context
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
            activityCallback?.onButtonClickA()
        }
        return binding.root
    }
}