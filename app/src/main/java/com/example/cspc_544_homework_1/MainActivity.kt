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
        }
        sideValues.clear()
    }

    private fun displayErrorMessage(message: String) {
        messageBox.text = message
        messageBox.setTextColor(Color.RED)
    }

    private fun setMessageBox() {
        messageBox = findViewById<TextView>(R.id.message_box)
    }

    fun onQuitButtonClicked(view: View) {
        val toastMessage = Toast.makeText(this@MainActivity, "Bye", Toast.LENGTH_SHORT)
//        toastMessage.setGravity(Gravity.TOP, 0, 0)
        toastMessage.show()
    }

    fun onSolveButtonClicked(view: View) {
        clearSideValuesArr()
        storeValues()
        if (inputsAreValid()){
            //solveTriangle
        }
    }

    private fun clearSideValuesArr(){
        sideValues.clear()
    }

    private fun storeValues() {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            val value = btn.text.toString().toFloat()
            sideValues.add(value)
        }
    }

    private fun inputsAreValid(): Boolean {
        if (!this.validValues()){
            displayErrorMessage(getString(R.string.invalidValuesMsg))
            return false
        }
        if(!this.hasThreeInputs()) {
            displayErrorMessage(getString(R.string.invalidEntiresMsg))
            return false
        }
        return true
    }

    private fun validValues(): Boolean {
        for (item in inputBoxes) {
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
}