package com.example.simplestateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timerLiveData = MutableLiveData<Int>()
    val timerLiveData = _timerLiveData as LiveData<Int>

    fun startTimer(){
        viewModelScope.launch{
            for (i in 1..20){
                _timerLiveData.value = i
                delay(1000L)
            }
        }
    }
}