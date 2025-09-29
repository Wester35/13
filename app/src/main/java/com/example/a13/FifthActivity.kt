package com.example.a13

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class FifthActivity : AppCompatActivity()  {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var colorChangeButton: Button
    private var currentTheme = 0
    private val themes = listOf(
        ThemeColors(
            textColor = Color.BLACK,
            buttonColor = Color.BLUE,
        ),
        ThemeColors(
            textColor = Color.BLUE,
            buttonColor = Color.RED,
        ),
        ThemeColors(
            textColor = Color.GRAY,
            buttonColor = Color.YELLOW,
        ),
        ThemeColors(
            textColor = Color.RED,
            buttonColor = Color.CYAN,
        ),
        ThemeColors(
            textColor = Color.GREEN,
            buttonColor = Color.MAGENTA,
        )
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.textView3)
        val backButton: Button = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            finish()
        }
        colorChangeButton = findViewById(R.id.theme_btn)
        colorChangeButton.setOnClickListener {
            changeColors()
        }
    }

    private fun changeColors() {
        currentTheme = (currentTheme + 1) % themes.size
        val theme = themes[currentTheme]

        textView1.setTextColor(theme.textColor)
        textView2.setTextColor(theme.textColor)

        colorChangeButton.setBackgroundColor(theme.buttonColor)

    }
    data class ThemeColors(
        val textColor: Int,
        val buttonColor: Int,
    )
}