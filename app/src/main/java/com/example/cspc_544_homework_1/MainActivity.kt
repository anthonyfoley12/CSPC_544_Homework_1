package com.example.cspc_544_homework_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var sideValues = ArrayList<Float>()
    private var inputBoxes = ArrayList<Int>()
    private val minVal = 1.0
    private val maxVal = 100.0
    lateinit var messageBox: TextView
    lateinit var clearButton: Button
    lateinit var solveButton: Button
    lateinit var quitButton: Button
    lateinit var input_1: EditText
    lateinit var input_2: EditText
    lateinit var input_3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageBox = findViewById(R.id.message_box)
        clearButton = findViewById(R.id.clear_button)
        solveButton = findViewById(R.id.solve_button)
        quitButton = findViewById(R.id.quit_button)
        input_1 = findViewById(R.id.input_1)
        input_2 = findViewById(R.id.input_2)
        input_3 = findViewById(R.id.input_3)
        inputBoxes.addAll(
            listOf(
                R.id.input_1,
                R.id.input_2,
                R.id.input_3
            )
        )
    }

    fun clearTextFields(view: View) {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            btn.text.clear()
            displayStartingMessage()
        }

    }

    private fun displayStartingMessage() {
        messageBox.text = getString(R.string.display_results_text)
        messageBox.setTextColor(Color.BLACK)
    }

    private fun displayErrorMessage(message: String) {
        messageBox.text = message
        messageBox.setTextColor(Color.RED)
    }

    private fun displayTriangleTypeMessage(message: String) {
        return
    }

    fun onQuitButtonClicked(view: View) {
        messageBox.setTextColor(Color.BLACK)
        messageBox.text = getString(R.string.byeMsg)
    }

    fun onSolveButtonClicked(view: View) {
        clearSideValuesArr()
        storeValues()
//        if (inputsAreValid() && inputsAreTriangle()){
//            displayTriangleTypeMessage(getTriangleType())
//        }

        if(inputsAreValid()) {
            messageBox.setTextColor(Color.GREEN)
            if(!inputsAreTriangle()) {
                messageBox.setTextColor(Color.parseColor("#FFAE42"))
            }
            displayTriangleTypeMessage(getTriangleType())
        }
    }

    private fun clearSideValuesArr(){
        sideValues.clear()
    }

    private fun storeValues() {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            if (btn.text.toString().isNotEmpty()) {
                val value = btn.text.toString()
                sideValues.add(value.toFloat())
            }
        }
    }

    private fun inputsAreValid(): Boolean {
        // hasThreeInputs() must come first. validValues assumes sideValues is not empty
        if(!hasThreeInputs()) {
            displayErrorMessage(getString(R.string.invalidEntriesMsg))
            return false
        }
        if (!validValues()){
            displayErrorMessage(getString(R.string.invalidValuesMsg))
            return false
        }

        return true
    }

    private fun validValues(): Boolean {
        for (item in sideValues) {
            if (item < minVal || item > maxVal) {
                return false
            }
        }
        return true
    }

    private fun hasThreeInputs(): Boolean {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            if (btn.text.toString().isEmpty()) {
                return false
            }
        }
        return true
    }

    private fun inputsAreTriangle(): Boolean {

        val sideA = sideValues[0]
        val sideB = sideValues[1]
        val sideC = sideValues[2]

        var result = false

        if ((sideA + sideB > sideC) &&
            (sideA + sideC > sideB) &&
            (sideB + sideC > sideA)) {
            result = true
        } else {
            displayErrorMessage(getString(R.string.notATraingle))
        }
        return result
    }

    private fun getTriangleType(): String {
        var sideA = sideValues[0]
        var sideB = sideValues[1]
        var sideC = sideValues[2]
        if (sideA == sideB && sideC == sideB && sideA == sideC)
            return getString(R.string.equilateral)
        else if (sideA == sideB || sideB == sideC || sideA == sideC)
            return getString(R.string.isosceles)
        else
            return getString(R.string.scalene)
    }
}