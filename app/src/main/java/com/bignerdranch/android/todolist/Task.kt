package com.bignerdranch.android.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val descript: String,
    val description: String,
    val priority: Int // 1 - High, 2 - Medium, 3 - Low
)