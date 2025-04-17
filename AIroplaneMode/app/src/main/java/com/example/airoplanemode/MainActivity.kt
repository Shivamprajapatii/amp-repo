package com.example.airoplanemode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.airoplanemode.AirPlaneBroadCast

class MainActivity : AppCompatActivity() {

    lateinit var reciver: AirPlaneBroadCast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        reciver = AirPlaneBroadCast()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {

            registerReceiver(reciver,it)

        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciver)
    }
}