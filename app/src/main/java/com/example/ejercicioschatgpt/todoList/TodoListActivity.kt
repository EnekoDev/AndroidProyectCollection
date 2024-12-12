package com.example.ejercicioschatgpt.todoList

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioschatgpt.databinding.ActivityTodoListBinding
import com.google.android.material.snackbar.Snackbar

class TodoListActivity:AppCompatActivity(), OnClickListener {

    private lateinit var binding:ActivityTodoListBinding
    private lateinit var taskAdapter:TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityTodoListBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.rvTaskList.layoutManager = LinearLayoutManager(this)
        populateRV()
        binding.addTask.setOnClickListener(this)
        binding.deleteTask.setOnClickListener(this)
    }

    private fun populateRV() {
        val taskDAO = TaskDAO(applicationContext)
        taskAdapter = TaskAdapter(taskDAO.getItems())
        binding.rvTaskList.adapter = taskAdapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.addTask.id -> {
                val newTask = Task(null, binding.etTaskName.text.toString())
                val taskDAO = TaskDAO(applicationContext)
                if (newTask.name.isNotBlank()) {
                    taskDAO.insertItem(newTask)
                } else {
                    Snackbar.make(this, v, "Actividad sin nombre", Snackbar.LENGTH_LONG).show()
                }
                populateRV()
            }
            binding.deleteTask.id -> {
                val taskSelected:String = binding.etTaskName.text.toString()
                val taskDAO = TaskDAO(applicationContext)
                if (taskSelected.isNotBlank()) {
                    taskDAO.deleteItem(taskSelected)
                } else {
                    Snackbar.make(this, v, "Actividad sin nombre", Snackbar.LENGTH_LONG).show()
                }
                populateRV()
            }
        }
    }
}