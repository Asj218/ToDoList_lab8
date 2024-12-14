package com.bignerdranch.android.todolist

import androidx.room.Database
import androidx.room.RoomDatabase

interface TaskDatabase {
    @Database(entities = [Task::class], version = 1)
    abstract class TaskDatabase : RoomDatabase() {
        abstract fun taskDao(): TaskDao
    }
}