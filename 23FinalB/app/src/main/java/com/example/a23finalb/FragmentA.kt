package com.example.`23FinalB`

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a23finalb.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var binding: FragmentABinding
    private lateinit var dictViewModel: DictViewModel
    var activityCallback: ClickLisner? = null

    interface ClickLisner {
        fun onButtonClick(rb: Int, sp: Long, sp2: Long)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is ClickLisner) {
                activityCallback = context
            }
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement ClickListener()")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false)
        dictViewModel = ViewModelProvider(this).get(DictViewModel::class.java)

        // 영어 스피너 설정
        val englishAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            dictViewModel.dictEnglish.map { it.word }
        )
        englishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = englishAdapter

        // 한글 스피너 설정
        val koreanAdapter = ArrayAdapter(
            requireContext(),
            R.layout.simple_spinner_item,
            dictViewModel.dictEnglish.map { it.definition }
        )
        koreanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = koreanAdapter

        // "단어 뜻" 버튼 클릭
        binding.button.setOnClickListener {
            val selectRbId = binding.radioGroup.checkedRadioButtonId
            val rbIndex = binding.radioGroup.indexOfChild(
                binding.radioGroup.findViewById(selectRbId)
            )
            val spId = binding.spinner.selectedItemId
            val sp2Id = binding.spinner2.selectedItemId

            activityCallback?.onButtonClick(rbIndex, spId, sp2Id)
        }

        return binding.root
    }

}