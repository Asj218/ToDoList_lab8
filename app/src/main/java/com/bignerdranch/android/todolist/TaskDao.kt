package com.bignerdranch.android.todolist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM tasks ORDER BY priority ASC")
    suspend fun getAllTasks(): List<Task>

    @Delete
    suspend fun delete(task: Task)
}

