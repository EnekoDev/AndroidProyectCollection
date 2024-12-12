package com.example.ejercicioschatgpt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioschatgpt.databinding.ActivityMainBinding
import com.example.ejercicioschatgpt.todoList.TodoListActivity
import com.example.ejercicioschatgpt.unitConversor.UnitConversorActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.chatgptLinkBtn.setOnClickListener(this)
        binding.todoActivityBtn.setOnClickListener(this)
        binding.unitConversorActivityBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.chatgptLinkBtn.id -> {

            }
            binding.todoActivityBtn.id -> {
                val intent = Intent(this, TodoListActivity::class.java)
                startActivity(intent)
            }
            binding.unitConversorActivityBtn.id -> {
                val intent = Intent(this, UnitConversorActivity::class.java)
                startActivity(intent)
            }
        }
    }
}