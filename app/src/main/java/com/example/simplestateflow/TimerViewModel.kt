package com.example.simplestateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
//    private val _timerLiveData = MutableLiveData<Int>()
//    val timerLiveData = _timerLiveData as LiveData<Int>

    private val _timerStateFlow = MutableStateFlow(0)
    val timerStateFlow = _timerStateFlow as StateFlow<Int>

    fun startTimer(){
        viewModelScope.launch{
            for (i in 1..20){
                _timerStateFlow.emit(i)
                delay(1000L)
            }
        }
    }
}