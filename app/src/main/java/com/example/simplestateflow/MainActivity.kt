package com.example.simplestateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var tvNum: TextView
    private lateinit var timerViewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNum = findViewById(R.id.tvNum)
        timerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]

        timerViewModel.startTimer()

        lifecycleScope.launchWhenStarted {
            timerViewModel.timerStateFlow.collect {
                println("Number : $it")
                tvNum.text = it.toString()
            }
        }
    }
}