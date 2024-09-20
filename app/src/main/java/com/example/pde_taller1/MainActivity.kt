package com.example.pde_taller1
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)

        val saludoTextView = findViewById<TextView>(R.id.saludoTextView)
        val buttonPrimary = findViewById<Button>(R.id.buttonPrimary)

        // Cambiar el saludo según la hora del día
        val saludo = obtenerSaludo()
        saludoTextView.text = saludo

        // Cargar el color de fondo guardado
        val savedColor = sharedPreferences.getInt("backgroundColor", ContextCompat.getColor(this, android.R.color.white))
        window.decorView.setBackgroundColor(savedColor)

        // Configurar el botón para ir a PrimaryActivity
        buttonPrimary.setOnClickListener {
            val intent = Intent(this, PrimaryActivity::class.java)
            startActivity(intent)
        }
    }

    // Función para obtener el saludo basado en la hora del día
    private fun obtenerSaludo(): String {
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (currentHour) {
            in 6..11 -> "Buenos días"
            in 12..18 -> "Buenas tardes"
            else -> "Buenas noches"
        }
    }
}
