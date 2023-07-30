package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

        settingNavigator()
    }

    private fun settingNavigator() {
        val bottomNavigator = findViewById<BottomNavigationView>(R.id.bottom_navigator)
        bottomNavigator.selectedItemId = R.id.button_my_order

        bottomNavigator.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.button_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left)
                    finish()
                    true
                }
                R.id.button_reward -> {
                    val intent = Intent(this, RewardActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left)
                    finish()
                    true
                }
                R.id.button_my_order -> {
                    true
                }

                else -> {
                    true
                }
            }
        }
    }
}