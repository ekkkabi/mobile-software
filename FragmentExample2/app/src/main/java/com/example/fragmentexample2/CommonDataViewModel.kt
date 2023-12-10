package com.example.fragmentexample2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonDataViewModel : ViewModel() {
    // 전달받는 값
    private var _myCount = MutableLiveData<Int>(0)

    // backUp muCount 
    val myCount: LiveData<Int> get() = _myCount
    
    fun setCount(cnt:Int){
        _myCount.value = cnt
    }
}