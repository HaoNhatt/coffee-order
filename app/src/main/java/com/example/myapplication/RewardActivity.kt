package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.PrintStream
import java.util.Scanner

class RewardActivity : AppCompatActivity() {
    private val REDEEMFILE = "user_redeem.txt"
    private val HISTORYFILE = "history.txt"
    private val LOYALCUP = "loyal_cup.txt"
    private var loyalCup = 0
    private var history = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        settingNavigator()
        setLoyalCup()
        setHistory()
        makeHistory()
    }

    override fun onResume() {
        super.onResume()

        setLoyalCup()
        setPoints()
    }

    private fun setPoints() {
        val reader = Scanner(openFileInput(REDEEMFILE))
        var redeemPoint = 0
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            redeemPoint = line.toInt()
            if (redeemPoint > 13400) {
                redeemPoint = 13400
                val outStream = PrintStream(openFileOutput(REDEEMFILE, MODE_PRIVATE))
                outStream.println(redeemPoint)
                outStream.close()
            }
        }
        findViewById<TextView>(R.id.user_points).text = redeemPoint.toString()
    }

    private fun setLoyalCup() {
        val reader = Scanner(openFileInput(LOYALCUP))
        loyalCup = reader.nextLine().toInt()
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
            0 -> {

            }
        }
        findViewById<TextView>(R.id.loyal_cup).text = buildString {
            append(loyalCup)
            append(" / 8")
        }
    }

    private fun setHistory() {
        val reader = Scanner(openFileInput(HISTORYFILE))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            history.add(line)
        }
    }

    private fun makeHistory() {
        val layoutHistory = findViewById<LinearLayout>(R.id.linear_layout_history_reward)

        for (i in 0 until history.size) {
            val item = layoutInflater.inflate(R.layout.reward_history, null)
            val line = history[i].split("\t")
            item.findViewById<TextView>(R.id.item_history_reward_name).text = line[0]
            layoutHistory.addView(item)
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

    private fun saveLoyalCup() {
        val outStream = PrintStream(openFileOutput(LOYALCUP, MODE_PRIVATE))
        outStream.println(loyalCup)
        outStream.close()
    }

    fun actionCheckCup(view: View) {
        if (loyalCup == 8) {
            val reader = Scanner(openFileInput(REDEEMFILE))
            var points = reader.nextLine()
            points += 670
            val outStream = PrintStream(openFileOutput(REDEEMFILE, MODE_PRIVATE))
            outStream.println(points)
            outStream.close()

            loyalCup = 0
            saveLoyalCup()
            setLoyalCup()
            setPoints()
        } else {
            Toast.makeText(this, "You don't have enough loyal cup", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()

        saveLoyalCup()
    }
}