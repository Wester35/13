package com.example.a13

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SeventhActivity : AppCompatActivity()  {

    private val correctAnswers = mapOf(
        "question1" to "Kotlin",

        "question2" to setOf("Кочетков", "Станислав", "Сафирович"),

        "question3" to "Москоу"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)


        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val checkButton: Button = findViewById(R.id.checkButton)
        val resultText: TextView = findViewById(R.id.resultText)

        checkButton.setOnClickListener {
            checkAnswers()
        }

    }
    private fun checkAnswers() {
        val resultText: TextView = findViewById(R.id.resultText)

        val question1Correct = checkQuestion1()
        val question2Correct = checkQuestion2()
        val question3Correct = checkQuestion3()

        val correctCount = listOf(question1Correct, question2Correct, question3Correct).count { it }
        val totalQuestions = 3

        // Формируем результат
        val result = StringBuilder()
        result.append("Результат: $correctCount из $totalQuestions\n\n")

        result.append("Вопрос 1: ${if (question1Correct) "Правильно" else "Неправильно"}\n")
        result.append("Вопрос 2: ${if (question2Correct) "Правильно" else "Неправильно"}\n")
        result.append("Вопрос 3: ${if (question3Correct) "Правильно" else "Неправильно"}\n")

        resultText.text = result.toString()

        if (correctCount == totalQuestions) {
            resultText.setTextColor(Color.GREEN)
            showToast("Маладес брат, все правильн")
        } else {
            resultText.setTextColor(Color.RED)
        }
    }

    private fun checkQuestion1(): Boolean {
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup1)
        val selectedId = radioGroup.checkedRadioButtonId

        if (selectedId == -1) {
            return false
        }

        val selectedRadio: RadioButton = findViewById(selectedId)
        return selectedRadio.text.toString() == correctAnswers["question1"]
    }

    private fun checkQuestion2(): Boolean {
        val selectedOptions = mutableSetOf<String>()

        val check1: CheckBox = findViewById(R.id.check2_1)
        val check2: CheckBox = findViewById(R.id.check2_2)
        val check3: CheckBox = findViewById(R.id.check2_3)
        val check4: CheckBox = findViewById(R.id.check2_4)
        val check5: CheckBox = findViewById(R.id.check2_5)
        val check6: CheckBox = findViewById(R.id.check2_6)

        if (check1.isChecked) selectedOptions.add("Кочетков")
        if (check2.isChecked) selectedOptions.add("Станислав")
        if (check3.isChecked) selectedOptions.add("Иван")
        if (check4.isChecked) selectedOptions.add("Змея")
        if (check5.isChecked) selectedOptions.add("Сафирович")
        if (check6.isChecked) selectedOptions.add("Какой то левый чел")

        @Suppress("UNCHECKED_CAST")
        val correctOptions = correctAnswers["question2"] as Set<String>

        return selectedOptions == correctOptions
    }

    private fun checkQuestion3(): Boolean {
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup3)
        val selectedId = radioGroup.checkedRadioButtonId

        if (selectedId == -1) {
            return false
        }

        val selectedRadio: RadioButton = findViewById(selectedId)
        return selectedRadio.text.toString() == correctAnswers["question3"]
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}