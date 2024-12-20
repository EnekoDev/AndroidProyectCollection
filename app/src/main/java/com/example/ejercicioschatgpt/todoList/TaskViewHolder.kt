package com.example.ejercicioschatgpt.todoList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioschatgpt.R

class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val tvTask:TextView = view.findViewById(R.id.tvTask)

    fun render(task:Task) {
        tvTask.text = task.name
    }
}