package com.example.fragmentsample2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentsample2.databinding.FragmentBBinding

const val ARG_PARAM = "fragment_B"

class FragmentB : Fragment() {
    interface ButtonListnerB {
        fun onButtonClickB()
    }

    private var activityCallback: ButtonListnerB? = null

    companion object {
        @JvmStatic
        fun newInstance(params: String) =
            /* val bundle = Bundle()
             bundle.putString(ARG_PARAM, params)
             arguments = bundle*/
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, params)
                }
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ButtonListnerB)
                activityCallback = context
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ButtonListenerB")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBBinding.inflate(inflater, container, false)
        var word: String? = null
        arguments?.let {
            word = it.getString(ARG_PARAM)
            binding.textView.text = word
        }

        binding.button.setOnClickListener {
            activityCallback?.onButtonClickB()
        }
        return binding.root
    }


}