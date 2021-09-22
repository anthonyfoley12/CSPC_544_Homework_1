package com.example.cspc_544_homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.view.Gravity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var sideValues = ArrayList<Float>()
    private var inputBoxes = ArrayList<Int>()
    private val minVal = 1.0
    private val maxVal = 100.0
    private lateinit var messageBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setInputBoxes()
        setMessageBox()
        messageBox.setOnClickListener(){
            this.onSolve()
        }
    }

    fun clearTextFields(view: View) {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            btn.text.clear()
        }
        sideValues.clear()
    }

    private fun setInputBoxes() {
        inputBoxes.addAll(
            listOf(
                R.id.input_1,
                R.id.input_2,
                R.id.input_3
            )
        )
    }
    private fun setMessageBox() {
        messageBox = findViewById<TextView>(R.id.textView)
    }
    fun onQuitButtonClicked(view: View) {
        val toastMessage = Toast.makeText(this@MainActivity, "Bye", Toast.LENGTH_SHORT)
//        toastMessage.setGravity(Gravity.TOP, 0, 0)
        toastMessage.show()
    }

    fun onSolveButtonClicked(view: View) {
        if(!this.hasThreeInputs()) {
            messageBox.text = getString(R.string.invalidEntiresMsg)
            return
        }
    }

    private fun onSolve() {
        this.storeValues()
        if (!this.validValues()){
            messageBox.text = getString(R.string.invalidValuesMsg)
            return
        }
        if(!this.hasThreeSides()) {
            messageBox.text = getString(R.string.invalidEntiresMsg)
            return
        }
        // solveTriangle()s
    }
    private fun storeValues() {
        for (box in inputBoxes) {
            val btn = findViewById<EditText>(box)
            val value = btn.text.toString().toFloat()
            sideValues.add(value)
        }
    }
    private fun validValues(): Boolean {
        for (item in inputBoxes) {
            if (item < minVal || item > maxVal) {
                return false
            }
        }
        return true
    }
     private fun hasThreeSides(): Boolean{
        return sideValues.size == 3
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