package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
//    var myCart =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        loadSplashscreen()
        Handler().postDelayed({
            // on below line we are
            // creating a new intent
            val i = Intent(
                this,
                HomeActivity::class.java
            )
            // on below line we are
            // starting a new activity.
            startActivity(i)

            // on the below line we are finishing
            // our current activity.
            finish()
        }, 2000)
    }
}