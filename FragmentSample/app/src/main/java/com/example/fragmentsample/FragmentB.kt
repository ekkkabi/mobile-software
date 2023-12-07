package com.example.fragmentsample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentsample.databinding.FragmentBBinding

class FragmentB : Fragment() {
    interface ButtonListenerB {
        fun onButtonClickB()
    }

    private var activityCallback: ButtonListenerB? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ButtonListenerB) {
                activityCallback = context
            }

        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ButtonListenerB")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_b, container, false)
        val binding = FragmentBBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            activityCallback?.onButtonClickB()
        }
        return binding.root
    }
}
