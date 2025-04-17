package com.example.mediaplayerapp
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.mediaplayerapp.MusicService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)

        val serviceIntent = Intent(this, MusicService::class.java)

        startBtn.setOnClickListener {
            startService(serviceIntent)
        }

        stopBtn.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}

