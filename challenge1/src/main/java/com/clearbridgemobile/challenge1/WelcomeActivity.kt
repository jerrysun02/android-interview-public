package com.clearbridgemobile.challenge1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class WelcomeActivity : ComponentActivity() {
    private val sharedPrefFile = "mySharedPreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putBoolean("isLaunched", true)
            editor.apply()
            editor.commit()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}