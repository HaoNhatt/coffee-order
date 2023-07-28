package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RewardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)
    }

    fun actionGoToRedeem(view: View) {
        val intent = Intent(this, RedeemActivity::class.java)
        startActivity(intent)
    }

    fun goToHomePage(view: View) {
        finish()
    }

    fun goToMyOrders(view: View) {
        finish()
    }
}