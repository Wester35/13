package com.example.a13

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class EighthActivity : AppCompatActivity()  {
    private lateinit var switch1: Switch
    private lateinit var switch2: Switch
    private lateinit var switch3: Switch
    private val COUNT_OF_CYCLES = 20
    private var counter_for_off = 0
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
            if (!isUpdating && counter_for_off < COUNT_OF_CYCLES) {
                isUpdating = true
                if (isChecked && switch2.isChecked && switch3.isChecked) {
                    switch2.isChecked = false
                    switch3.isChecked = false
                }
                isUpdating = false
                counter_for_off++
                if (counter_for_off >= COUNT_OF_CYCLES){
                    Toast.makeText(this, "ПОЗДРАВЛЯЮ, ВЫ БЫЛИ УБИТЫ СОБОЙ",
                        Toast.LENGTH_SHORT).show()
                    counter_for_off = 0
                }
            }
        }

        switch2.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdating && counter_for_off < COUNT_OF_CYCLES) {
                isUpdating = true
                if (isChecked && switch1.isChecked && switch3.isChecked) {
                    switch1.isChecked = false
                    switch3.isChecked = false
                }
                isUpdating = false
                counter_for_off++
                if (counter_for_off >= COUNT_OF_CYCLES){
                    Toast.makeText(this, "ПОЗДРАВЛЯЮ, ВЫ БЫЛИ УБИТЫ СОБОЙ",
                        Toast.LENGTH_SHORT).show()
                    counter_for_off = 0
                }
            }
        }

        switch3.setOnCheckedChangeListener { _, isChecked ->
            if (!isUpdating && counter_for_off < COUNT_OF_CYCLES) {
                isUpdating = true
                if (isChecked && switch1.isChecked && switch2.isChecked) {
                    switch1.isChecked = false
                    switch2.isChecked = false
                }
                isUpdating = false
                counter_for_off++
                if (counter_for_off >= COUNT_OF_CYCLES){
                    Toast.makeText(this, "ПОЗДРАВЛЯЮ, ВЫ БЫЛИ УБИТЫ СОБОЙ",
                        Toast.LENGTH_SHORT).show()
                    counter_for_off = 0
                }

            }
        }


    }
}