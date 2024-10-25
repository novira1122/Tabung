package id.ac.polbeng.noviraasnani.tabung

package com.example.cylinderapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.novirasnani.tabung.databinding.ActivityMainBinding
import kotlin.math.PI

class MainActivity : AppCompatActivity() {

    // Declare binding variable
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set button click listener
        binding.btnCalculate.setOnClickListener {
            calculateCylinder()
        }
    }

    private fun calculateCylinder() {
        // Get user input
        val radius = binding.etRadius.text.toString().toDoubleOrNull()
        val height = binding.etHeight.text.toString().toDoubleOrNull()

        // Validate input
        if (radius == null || height == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        // Calculate volume and surface area
        val volume = PI * radius * radius * height
        val surfaceArea = 2 * PI * radius * (radius + height)

        // Display the result
        binding.tvResult.text = """
            Volume: $volume
            Surface Area: $surfaceArea
        """.trimIndent()
    }
}
