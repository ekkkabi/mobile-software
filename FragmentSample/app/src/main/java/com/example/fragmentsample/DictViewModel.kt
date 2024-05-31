package com.example.fragmentsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DictViewModel : ViewModel() {
    val dictEnglish = listOf<Dict>(
        Dict("inadvertent", "부주의한, 소홀한"),
        Dict("debilitate", "쇠약하게 하다"),
        Dict("obviate", "(위험이나 곤란을)제거하다"),
        Dict("urbane", "우아한"),
        Dict("enliven", "활기있게 하다")
    )
}