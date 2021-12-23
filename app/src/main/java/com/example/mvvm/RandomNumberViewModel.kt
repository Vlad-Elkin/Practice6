package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel: ViewModel() {
    val currentRandomNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun onRandomClicked() {
        currentRandomNumber.value = (0..50).random();
    }
}