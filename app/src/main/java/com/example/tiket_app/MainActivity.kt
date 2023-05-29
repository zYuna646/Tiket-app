package com.example.tiket_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var spinnerDestination: Spinner
    private lateinit var buttonOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        spinnerDestination = findViewById(R.id.spinnerDestination)
        buttonOrder = findViewById(R.id.buttonOrder)

        val destinations = resources.getStringArray(R.array.destination_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDestination.adapter = adapter

        buttonOrder.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val destination = spinnerDestination.selectedItem.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && destination.isNotEmpty()) {
                val message = "Tiket berhasil dipesan!\n\nNama: $name\nEmail: $email\nTujuan: $destination"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
