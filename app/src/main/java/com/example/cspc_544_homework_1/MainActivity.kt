package com.example.cspc_544_homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val sideValues = ArrayList<Float>()
    private val inputBoxes = arrayListOf(
        R.id.editTextNumberDecimal,
        R.id.editTextNumberDecimal4,
        R.id.editTextNumberDecimal5
    )
    private final val minVal = 1.0
    private final val maxVal = 100.0
    private val messageBox = findViewById<TextView>(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onQuitButtonClicked(view: View) {
        val toastMessage = Toast.makeText(this@MainActivity, "Bye", Toast.LENGTH_SHORT)
//        toastMessage.setGravity(Gravity.TOP, 0, 0)
        toastMessage.show()
    }
    public fun onSolve(view: View) {
        storeValues(view)
        if (!validValues()){
            messageBox.text = "Invalid Values. Please make sure all values are betwen 1.0 - 100.0."
            // return
        }
        if(!hasThreeSides()) {
            // Set Output Message
            // return
        }
        // solveTriangle()s
    }
    private fun storeValues(view: View) {
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

}