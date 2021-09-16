package com.example.cspc_544_homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onQuitButtonClicked(view: View) {

        val toastMessage = Toast.makeText(this@MainActivity, "Bye", Toast.LENGTH_SHORT)
//        toastMessage.setGravity(Gravity.TOP, 0, 0)
        toastMessage.show()
    }
}