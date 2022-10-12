package com.example.simplestateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var tvNum : TextView
    private lateinit var timerViewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNum = findViewById(R.id.tvNum)
        timerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]

        timerViewModel.startTimer()

        timerViewModel.timerLiveData.observe(this) { num ->
            println("Number : $num")
            tvNum.text = num.toString()
        }
    }
}