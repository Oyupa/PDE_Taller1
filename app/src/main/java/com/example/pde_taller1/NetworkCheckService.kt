package com.example.pde_taller1

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.IBinder

class NetworkCheckService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Iniciar el hilo
        Thread {
            try {
                // Simular la comprobación de red
                Thread.sleep(5000)

                // Enviar una señal de que la simulación ha terminado
                val resultIntent = Intent("NETWORK_STATUS")
                resultIntent.putExtra("isComplete", true)
                sendBroadcast(resultIntent)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                // Asegúrate de que el servicio se detiene cuando la tarea termina
                stopSelf()
            }
        }.start()

        return START_NOT_STICKY
    }
}

