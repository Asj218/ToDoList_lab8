package com.bignerdranch.android.todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    // Создаем экземпляр TaskViewModelFactory
    private val viewModel: TaskViewModel by viewModels { TaskViewModelFactory((application as TodoApplication).repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TaskAdapter()
        recyclerView.adapter = adapter

        viewModel.allTasks.observe(this) { tasks ->
            tasks?.let { adapter.submitList(it) }
        }

        fab.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }
}
