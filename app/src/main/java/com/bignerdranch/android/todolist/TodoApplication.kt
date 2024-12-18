package com.bignerdranch.android.todolist

import android.app.Application

class TodoApplication : Application() {
    lateinit var repository: TaskRepository
    lateinit var viewModelFactory: TaskViewModelFactory

    override fun onCreate() {
        super.onCreate()
        // Инициализация базы данных и репозитория
        val taskDao = TaskDatabase.getDatabase(this).taskDao()
        repository = TaskRepository(taskDao)

        // Инициализация фабрики ViewModel
        viewModelFactory = TaskViewModelFactory(repository)
    }
}