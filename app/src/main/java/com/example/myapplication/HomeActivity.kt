package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
//    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//        if (it.resultCode == RESULT_OK) {
//            val screen = it.data?.getStringExtra("screen") ?: ""
//            when (screen) {
//                "rewards" -> {
//                    val intent = Intent(this, RewardActivity::class.java)
//                    startForResult!!.launch(intent)
//                }
//                "myOrder" -> {
//
//                }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        settingNavigator()
        setLoyalCup()
    }

    private fun settingNavigator() {
        val bottomNavigator = findViewById<BottomNavigationView>(R.id.bottom_navigator)
        bottomNavigator.selectedItemId = R.id.button_home

        bottomNavigator.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.button_home -> {
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

    fun goToCart(view: View) {
        val intent = Intent(this, MyCartActivity::class.java)
        startActivity(intent)
    }

    fun goToProfile(view: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }


    fun details(view: View) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", view.tag.toString())
        startActivity(intent)
    }

    fun goToOrderSuccess(view: View) {
        val intent = Intent(this, OrderSuccessActivity::class.java)
        startActivity(intent)
    }
}