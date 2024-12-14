package com.bignerdranch.android.todolist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.lifecycle.LiveData

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM tasks ORDER BY priority ASC")
    fun getAllTasks(): LiveData<List<Task>>

    @Delete
    suspend fun delete(task: Task)
}

