package com.example.calculator

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.calculator.R

class MusicService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private val CHANNEL_ID = "MusicServiceChannel"

    override fun onCreate() {
        super.onCreate()
        Log.d("MusicService", "Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MusicService", "Service started")
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()

        // Create a notification channel for foreground service (for Android O and above)
        createNotificationChannel()

        // Create a notification for foreground service
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Music Playing")
            .setContentText("Your background music is playing")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .build()

        // Start the service as a foreground service
        startForeground(1, notification)

        // Initialize and start MediaPlayer only if it's not already started
        if (mediaPlayer == null) {
            try {
                mediaPlayer = MediaPlayer.create(this, R.raw.simple) // Ensure you have "simple.mp3" in res/raw
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
                Log.d("MusicService", "MediaPlayer started")
            } catch (e: Exception) {
                Log.e("MusicService", "MediaPlayer failed: ${e.message}")
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Properly release MediaPlayer when the service is stopped
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()
        Log.d("MusicService", "Service destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    // Create a notification channel for Android O and above
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Music Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}
