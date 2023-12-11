package com.example.a21fianalano2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import com.example.a21fianalano2.databinding.FragmentPrintBinding

private lateinit var binding: FragmentPrintBinding

class PrintFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrintBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun changeStr1(user: Int, c: Int) {
        val msg = when {
            (user == c) -> getString(R.string.draw)
            ((user == 0 && c == 2) ||
                    (user == 1 && c == 1) ||
                    (user == 2 && c == 2)) -> getString(R.string.win)

            else -> getString(R.string.lose)
        }
        binding.resultStr.text = msg
    }

    fun changeStr2() {
        val msg = getString(R.string.guess)
        binding.resultStr.text = msg
    }

}