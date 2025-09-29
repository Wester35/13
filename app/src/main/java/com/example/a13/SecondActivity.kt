package com.example.a13

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SecondActivity : AppCompatActivity()  {

    private val textViews = mutableListOf<TextView>()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val backButton: Button = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            finish()
        }

        val textView1: TextView = findViewById(R.id.hw1)
        val textView2: TextView = findViewById(R.id.hw2)
        val textView3: TextView = findViewById(R.id.hw3)
        val textView4: TextView = findViewById(R.id.hw4)
        val textView5: TextView = findViewById(R.id.hw5)


        textViews.addAll(listOf(textView1, textView2, textView3, textView4, textView5))


        textViews.forEach { it.visibility = View.INVISIBLE }

        startLoop()
    }

    private fun startLoop() {
        val handler = Handler(Looper.getMainLooper())

        val runnable = object : Runnable {
            override fun run() {
                if (currentIndex < textViews.size) {
                    textViews[currentIndex].visibility = View.VISIBLE
                    currentIndex++

                    handler.postDelayed(this, 1000)
                }
            }
        }

        handler.post(runnable)
    }
}