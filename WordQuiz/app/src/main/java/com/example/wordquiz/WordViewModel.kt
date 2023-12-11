package com.example.wordquiz

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordViewModel : ViewModel() {

    private val wordBank = listOf<Word>(
        Word("부주의한, 소홀한", arrayOf("degenerate", "unity", "inadvertent", "array"), 3),
        Word("쇠약하게 하다", arrayOf("vanity", "underhand", "enslave", "debilitate"), 4),
        Word("(위험·곤란)제거하다", arrayOf("artisan", "sadistic", "glossy", "obviate"), 4),
        Word("우아한", arrayOf("prostrate", "delude", "urbane", "renowned"), 3),
        Word("활기있게 하다", arrayOf("bereave", "enliven", "occult", "besiege"), 2)
    )
    private var curIndex = 0

    val curAnswer : Int
        get() = wordBank[curIndex].answer
    val curQuestion
        get() = wordBank[curIndex].question
    val curNumbers : Array<String>
        get() = wordBank[curIndex].numbers

    fun moveToNext(){
        if (wordBank.size == curIndex + 1) {
            var msg = "마지막 페이지입니다."
        } else {
            curIndex += 1
        }
    }

    fun moveToPrevious(){
        if (curIndex == 0) {
            var msg = "첫 페이지입니다."
        } else curIndex -= 1
    }

}