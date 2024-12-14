package com.bignerdranch.android.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class AddActivity : AppCompatActivity() {
    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val description = editTextTask.text.toString()
            val priority = when {
                findViewById<RadioButton>(R.id.radioHigh).isChecked -> 1
                findViewById<RadioButton>(R.id.radioMedium).isChecked -> 2
                else -> 3
            }
            val task = Task(description = description, priority = priority)
            viewModel.insert(task)
            finish()
        }
    }
}
