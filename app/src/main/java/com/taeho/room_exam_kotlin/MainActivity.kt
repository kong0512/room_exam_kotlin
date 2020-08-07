package com.taeho.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.taeho.room_exam_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val viewModel by viewModels<MainViewModel>()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }
}