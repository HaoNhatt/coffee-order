package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class RewardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        settingNavigator()
        setLoyalCup()
    }

    override fun onResume() {
        super.onResume()

        setLoyalCup()
    }

    private fun setLoyalCup() {
        val loyalCup = this.resources.getInteger(R.integer.loyal_cup)
        when (loyalCup) {
            8 -> {
                findViewById<ImageView>(R.id.loyal_cup_8).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_7).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_6).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_5).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_4).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            7 -> {
                findViewById<ImageView>(R.id.loyal_cup_7).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_6).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_5).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_4).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            6 -> {
                findViewById<ImageView>(R.id.loyal_cup_6).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_5).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_4).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            5 -> {
                findViewById<ImageView>(R.id.loyal_cup_5).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_4).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            4 -> {
                findViewById<ImageView>(R.id.loyal_cup_4).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            3 -> {
                findViewById<ImageView>(R.id.loyal_cup_3).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            2 -> {
                findViewById<ImageView>(R.id.loyal_cup_2).setImageResource(R.drawable.cup_on)
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
            1 -> {
                findViewById<ImageView>(R.id.loyal_cup_1).setImageResource(R.drawable.cup_on)
            }
        }
        findViewById<TextView>(R.id.loyal_cup).text = buildString {
            append(loyalCup)
            append(" / 8")
        }
    }

    private fun settingNavigator() {
        val bottomNavigator = findViewById<BottomNavigationView>(R.id.bottom_navigator)
        bottomNavigator.selectedItemId = R.id.button_reward

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
                    true
                }
                R.id.button_my_order -> {
                    val intent = Intent(this, MyOrderActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_right, R.anim.slide_left)
                    finish()
                    true
                }

                else -> {
                    true
                }
            }
        }
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