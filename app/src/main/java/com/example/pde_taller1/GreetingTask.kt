package com.example.pde_taller1
import android.os.AsyncTask
import java.util.*

class GreetingTask(private val onComplete: (String) -> Unit) : AsyncTask<Void, Void, String>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): String {
        // Simulamos una tarea de larga duración (por ejemplo, obtener la hora del servidor)
        Thread.sleep(2000)

        // Obtener la hora actual
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        // Determinar el saludo según la hora del día
        return when {
            currentHour in 3..11 -> "Buenos días"
            currentHour in 12..20 -> "Buenas tardes"
            else -> "Buenas noches"
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        onComplete(result) // Callback cuando se completa la tarea
    }
}