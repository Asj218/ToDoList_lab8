package com.bignerdranch.android.todolist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import retrofit2.http.Query

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks ORDER BY priority ASC")
    suspend fun getAllTasks(): List<Task>
}
