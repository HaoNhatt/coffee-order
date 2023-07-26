package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OrderSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success)
    }

    fun goToMyOrders(view: View) {
        val intent = Intent(this, MyOrderActivity::class.java)
        startActivity(intent)
    }
}