package com.example.ejercicioschatgpt.cronometro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicioschatgpt.R
import com.example.ejercicioschatgpt.databinding.ActivityCronometroBinding

class CronometroActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCronometroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCronometroBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}