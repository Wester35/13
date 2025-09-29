package com.example.a13

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class EighthActivity : AppCompatActivity()  {
    private lateinit var switch1: Switch
    private lateinit var switch2: Switch
    private lateinit var switch3: Switch
    private var isUpdating = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eighth)

        switch1 = findViewById(R.id.switch1)
        switch2 = findViewById(R.id.switch2)
        switch3 = findViewById(R.id.switch3)
        val backButton: Button = findViewById(R.id.back_btn)
        backButton.setOnClickListener {
            finish()
        }

        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdating) {
                isUpdating = true
                if (isChecked && switch2.isChecked && switch3.isChecked) {
                    switch2.isChecked = false
                    switch3.isChecked = false
                }
                isUpdating = false
            }
        }

        switch2.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdating) {
                isUpdating = true
                if (isChecked && switch1.isChecked && switch3.isChecked) {
                    switch1.isChecked = false
                    switch3.isChecked = false
                }
                isUpdating = false
            }
        }

        switch3.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdating) {
                isUpdating = true
                if (isChecked && switch1.isChecked && switch2.isChecked) {
                    switch1.isChecked = false
                    switch2.isChecked = false
                }
                isUpdating = false
            }
        }


    }
}