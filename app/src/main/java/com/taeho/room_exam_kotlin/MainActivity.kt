package com.taeho.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(todo_edit.text.toString()))
            }
        }
    }
}