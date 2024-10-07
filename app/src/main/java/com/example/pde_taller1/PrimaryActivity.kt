package com.example.pde_taller1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat

class PrimaryActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private var registeredName: String? = null
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primary)

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val textViewRegisteredName = findViewById<TextView>(R.id.textViewRegisteredName)
        val buttonSettings = findViewById<Button>(R.id.buttonSettings)
        progressBar = findViewById(R.id.progressBar)  // Inicializa el ProgressBar

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
            if (name.isEmpty()) {
                Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
            } else {
                registeredName = name
                textViewRegisteredName.text = "Nombre registrado: $registeredName"
                sharedPreferences.edit().putString("registeredName", name).apply()
                Toast.makeText(this, "Nombre guardado", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar botón de configuración
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        // Configurar botón de comprobar red
        val buttonCheckNetwork = findViewById<Button>(R.id.buttonCheckNetwork)
        buttonCheckNetwork.setOnClickListener {
            checkNetwork()
        }
    }

    private fun checkNetwork() {
        progressBar.visibility = View.VISIBLE  // Mostrar el ProgressBar
        Thread {
            // Simular la comprobación de red
            Thread.sleep(3000)  // Simula un retraso de 3 segundos
            runOnUiThread {
                progressBar.visibility = View.GONE  // Ocultar el ProgressBar
                Toast.makeText(this, "Conexión de red verificada", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }
}

