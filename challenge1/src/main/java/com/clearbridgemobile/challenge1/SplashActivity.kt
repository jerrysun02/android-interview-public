package com.clearbridgemobile.challenge1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    private val sharedPrefFile = "mySharedPreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            delay(3000)
            nextScreen()
        }
    }

    private fun nextScreen() {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)
        val isLaunched = sharedPreferences.getBoolean("isLaunched", false)
        if (isLaunched)
            startActivity(Intent(this, MainActivity::class.java))
        else
            startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }
}