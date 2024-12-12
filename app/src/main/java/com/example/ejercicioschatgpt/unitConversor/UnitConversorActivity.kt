package com.example.ejercicioschatgpt.unitConversor

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicioschatgpt.R
import com.example.ejercicioschatgpt.databinding.ActivityUnitConversorBinding

class UnitConversorActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding:ActivityUnitConversorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnitConversorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        populateSpinner()
        binding.convertirBtn.setOnClickListener(this)
    }

    private fun populateSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.longitudes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.conversorSpinner.setAdapter(adapter)
    }

    private fun convertUnit(convertion:String, unit:Double) {
        when (convertion) {
            "milimetro" -> {
                val result:Double = unit / 1000
                binding.resultText.text = String.format("$result metros")
            }
            "centimetro" -> {
                val result:Double = unit / 100
                binding.resultText.text = String.format("$result metros")
            }
            "decimetro" -> {

                val result:Double = unit / 10
                binding.resultText.text = String.format("$result metros")
            }
            "decametro" -> {
                val result:Double = unit * 10
                binding.resultText.text = String.format("$result metros")
            }
            "hectometro" -> {
                val result:Double = unit * 100
                binding.resultText.text = String.format("$result metros")
            }
            "kilometro" -> {
                val result:Double = unit * 1000
                binding.resultText.text = String.format("$result metros")
            }
        }
    }

    override fun onClick(v: View?) {
        val unit:Double = binding.datoEditText.editableText.toString().toDouble()
        val convertion:String = binding.conversorSpinner.selectedItem.toString()
        convertUnit(convertion, unit)
    }
}