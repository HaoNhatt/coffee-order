package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
    }

    fun goToOrderSuccess(view: View) {
        val intent = Intent(this, OrderSuccessActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goBack(view: View) {
        finish()
    }
}