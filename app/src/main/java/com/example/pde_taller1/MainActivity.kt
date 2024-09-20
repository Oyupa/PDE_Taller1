package com.example.pde_taller1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saludoTextView = findViewById<TextView>(R.id.saludoTextView)
        val buttonPrimary = findViewById<Button>(R.id.buttonPrimary)

        // Cambiar el saludo según la hora del día
        val saludo = obtenerSaludo()
        saludoTextView.text = saludo

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
            in 5..11 -> "Buenos días"
            in 12..17 -> "Buenas tardes"
            else -> "Buenas noches"
        }
    }
}
