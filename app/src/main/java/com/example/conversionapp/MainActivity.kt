package com.example.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.conversionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val units = arrayOf(
        "Select Conversion",
        "Km to Mi",
        "Mi to Km",
        "Cm to In",
        "In to Cm",
        "L to Cups",
        "Cups to L"
    )

    private val answerArray = arrayOf(0.0, 0.62137119, 1.609344, 0.39370079, 2.54, 4.17, 0.45)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, units)
        binding.spUnits.adapter = adapter

        binding.btnCalculate.setOnClickListener {
            if (binding.etAmount.text.isEmpty()) {
                binding.etAmount.error = "Please enter amount"
            } else {
                val amount = binding.etAmount.text.toString().toDouble()
                val result = amount * answerArray[binding.spUnits.selectedItemPosition]

                binding.tvAnswer.text = result.toString()
            }
        }
    }
}