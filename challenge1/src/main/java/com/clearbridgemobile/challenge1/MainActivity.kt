package com.clearbridgemobile.challenge1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textViewTime)
        textView.text = "Hi there\n\nThe time now is " + getCurrentTime()
    }

    fun getCurrentTime(): Date = Calendar.getInstance().time
}
