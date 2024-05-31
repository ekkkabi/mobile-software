package com.example.`23FinalB`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a23finalb.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun showRst(rb: Int, sp: Long, sp2: Long) {
        val dictViewModel = ViewModelProvider(requireActivity()).get(DictViewModel::class.java)

        // 선택된 항목의 영단어/한글뜻
        val selectWord: String
        val selectMeaning: String

        if (rb == 0) { // 첫 번째 라디오 버튼 (영어 단어) 선택
            selectWord = dictViewModel.dictEnglish[sp.toInt()].word
            selectMeaning = dictViewModel.dictEnglish[sp.toInt()].definition
        } else { // 두 번째 라디오 버튼 (한글 뜻) 선택
            selectWord = dictViewModel.dictEnglish[sp2.toInt()].word
            selectMeaning = dictViewModel.dictEnglish[sp2.toInt()].definition
        }

        // UI 나타내기
        binding.engTextView.text = "$selectWord"
        binding.hangulTextView.text = "$selectMeaning"
    }
}