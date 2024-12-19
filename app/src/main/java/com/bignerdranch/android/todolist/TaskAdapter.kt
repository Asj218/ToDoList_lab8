package com.bignerdranch.android.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class TaskAdapter : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = getItem(position)
        holder.bind(currentTask)
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskDescription: TextView = itemView.findViewById(R.id.task_description)
        private val taskDescript: TextView = itemView.findViewById(R.id.subtitle_input)

        fun bind(task: Task) {
            taskDescription.text = task.description
            taskDescript.text = task.descript

            // Установка цвета в зависимости от приоритета
            when (task.priority) {
                1 -> itemView.setBackgroundColor(0xffff4444.toInt())
                2 -> itemView.setBackgroundColor(0xffffbb33.toInt())
                3 -> itemView.setBackgroundColor(0xff99cc00.toInt())
            }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    fun getItemAtPosition(position: Int): Task {
        return getItem(position) // Возвращаем элемент по позиции
    }
}