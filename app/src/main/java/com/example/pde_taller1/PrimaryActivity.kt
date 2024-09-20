package com.example.pde_taller1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat

class PrimaryActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private var registeredName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primary)

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val textViewRegisteredName = findViewById<TextView>(R.id.textViewRegisteredName)
        val buttonSettings = findViewById<Button>(R.id.buttonSettings)

        // Cargar el color de fondo guardado
        val savedColor = sharedPreferences.getInt("backgroundColor", ContextCompat.getColor(this, android.R.color.white))
        window.decorView.setBackgroundColor(savedColor)

        // Cargar el nombre guardado
        registeredName = sharedPreferences.getString("registeredName", null)
        if (registeredName != null) {
            textViewRegisteredName.text = "Nombre registrado: $registeredName"
        }

        // Configurar botón de guardar
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString().trim()

            // Validar si el nombre no está vacío
            if (name.isEmpty()) {
                Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar el nombre y actualizar el TextView
                registeredName = name
                textViewRegisteredName.text = "Nombre registrado: $registeredName"
                // Guardar en SharedPreferences
                sharedPreferences.edit().putString("registeredName", name).apply()
                Toast.makeText(this, "Nombre guardado", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar botón de configuración
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
