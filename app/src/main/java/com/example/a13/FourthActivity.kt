package com.example.a13

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class FourthActivity : AppCompatActivity()  {
    private val colors = intArrayOf(
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.MAGENTA,
        Color.BLACK
    )


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
        setContentView(R.layout.activity_fourth)

        changeView = findViewById(R.id.changeTextView2)
        val backButton: Button = findViewById(R.id.back_btn)
        val changeButton: ImageButton = findViewById(R.id.imageButton)

        backButton.setOnClickListener {
            finish()
        }

        changeButton.setOnClickListener {
            changeText()
            changeColor()
        }

    }

    private fun changeText() {
        changeView.text = texts[currentIndex]
        currentIndex++

        if (currentIndex >= texts.size) {
            currentIndex = 0
        }
    }

    private fun changeColor() {
        changeView.setTextColor(colors[currentIndex % colors.size])
    }
}