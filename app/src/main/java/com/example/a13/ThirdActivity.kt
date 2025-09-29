package com.example.a13

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ThirdActivity : AppCompatActivity()  {
    private val texts = arrayOf(
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Chetverg",
        "Friday",
        "Saturday"
    )
    private var currentIndex = 0
    private lateinit var changeView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        changeView = findViewById(R.id.changeTextView)
        val backButton: Button = findViewById(R.id.back_btn)
        val changeButton: Button = findViewById(R.id.change_button)

        backButton.setOnClickListener {
            finish()
        }

        changeButton.setOnClickListener {
            changeText()
        }

    }

    private fun changeText() {
        changeView.text = texts[currentIndex]
        currentIndex++

        if (currentIndex >= texts.size) {
            currentIndex = 0
        }
    }
}