package com.example.menuitem

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    // Load the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Settings clicked",
                    Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Search clicked",
                    Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_feedback -> {
                Toast.makeText(this, "Feedback clicked",
                    Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_email -> {
// Compose Email is disabled — won't be clickable
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}