package com.bignerdranch.android.todolist

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks() // Теперь работает корректно

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }
}
