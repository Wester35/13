package com.example.a13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)


        button1.setOnClickListener { openScreen(FirstActivity::class.java) }
        button2.setOnClickListener { openScreen(SecondActivity::class.java) }
        button3.setOnClickListener { openScreen(ThirdActivity::class.java) }
        button4.setOnClickListener { openScreen(FourthActivity::class.java) }
        button5.setOnClickListener { openScreen(FifthActivity::class.java) }
        button6.setOnClickListener { openScreen(SixthActivity::class.java) }
        button7.setOnClickListener { openScreen(SeventhActivity::class.java) }
        button8.setOnClickListener { openScreen(EighthActivity::class.java) }
    }

    private fun openScreen(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}