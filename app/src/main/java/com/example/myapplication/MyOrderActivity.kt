package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.PrintStream
import java.util.Scanner

class MyOrderActivity : AppCompatActivity() {
    private val ONGOINGFILE = "on_going.txt"
    private val HISTORYFILE = "history.txt"
    private val USERINFOFILE = "user_info.txt"
    private val REDEEMFILE = "user_redeem.txt"
    private val LOYALCUP = "loyal_cup.txt"
    private var onGoing = ArrayList<String>()
    private var history = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

        settingNavigator()
        setOnGoing()
        setHistory()
        display()
        Log.d("HaoNhatTest", "ongoing ${onGoing}")
        Log.d("HaoNhatTest", "history ${history}")
    }

    private fun setOnGoing() {
        val reader = Scanner(openFileInput(ONGOINGFILE))
        var drinkName = ""
        var drinkPrice = ""
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            val drinkDetails = line.split("\t")
            drinkName = drinkDetails[0]
            drinkPrice = drinkDetails[6]
            val reader2 = Scanner(openFileInput(USERINFOFILE))
            val line2 = reader2.nextLine()
            val address = line2.split("\t")[3]
            onGoing.add("$drinkName\t$address\t$drinkPrice")
        }
    }

    private fun setHistory() {
        val reader = Scanner(openFileInput(HISTORYFILE))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            history.add(line)
        }
    }

    private fun display() {
        val layoutHistory = findViewById<LinearLayout>(R.id.linear_layout_history)
        val status = findViewById<BottomNavigationView>(R.id.top_navigator)
        status.selectedItemId = R.id.on_going

        for (i in 0 until onGoing.size) {
            val item = layoutInflater.inflate(R.layout.order_on_going, null)
            item.findViewById<RelativeLayout>(R.id.item_relative_layout).tag = i.toString()
            val line = onGoing[i].split("\t")
            item.findViewById<TextView>(R.id.item_name_on_going).text = line[0]
            item.findViewById<TextView>(R.id.item_address_on_going).text = line[1]
            item.findViewById<TextView>(R.id.item_total_price_on_going).text = buildString {
                append("$")
                append(line[2])
            }
            layoutHistory.addView(item)
        }

        status.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.on_going -> {
                    layoutHistory.removeAllViews()
                    for (i in 0 until onGoing.size) {
                        val item = layoutInflater.inflate(R.layout.order_on_going, null)
                        item.findViewById<RelativeLayout>(R.id.item_relative_layout).tag = i.toString()
                        val line = onGoing[i].split("\t")
                        item.findViewById<TextView>(R.id.item_name_on_going).text = line[0]
                        item.findViewById<TextView>(R.id.item_address_on_going).text = line[1]
                        item.findViewById<TextView>(R.id.item_total_price_on_going).text = buildString {
                            append("$")
                            append(line[2])
                        }
                        layoutHistory.addView(item)
                    }
                    true
                }
                R.id.history -> {
                    layoutHistory.removeAllViews()
                    for (i in 0 until history.size) {
                        val item = layoutInflater.inflate(R.layout.order_history, null)
                        val line = history[i].split("\t")
                        item.findViewById<TextView>(R.id.item_name).text = line[0]
                        item.findViewById<TextView>(R.id.item_address).text = line[1]
                        item.findViewById<TextView>(R.id.item_total_price).text = buildString {
                            append("$")
                            append(line[2])
                        }
                        layoutHistory.addView(item)
                    }
                    true
                }

                else -> {
                    true
                }
            }
        }
    }

    fun checkToHistory(view: View) {
        val position = view.tag.toString().toInt()
        history.add(onGoing[position])
        saveHistory()
        findViewById<BottomNavigationView>(R.id.top_navigator).selectedItemId = R.id.history
        Log.d("HaoNhatTest", "Check")

        onGoing.removeAt(position)
        saveOnGoing()

        var reader = Scanner(openFileInput(REDEEMFILE))
        var points = reader.nextLine().toInt()
        points += 12

        var outStream = PrintStream(openFileOutput(REDEEMFILE, MODE_PRIVATE))
        outStream.println(points)
        outStream.close()

        reader = Scanner(openFileInput(LOYALCUP))
        var loyalCup = reader.nextLine().toInt()

        if (loyalCup < 8) {
            loyalCup += 1
            outStream = PrintStream(openFileOutput(LOYALCUP, MODE_PRIVATE))
            outStream.println(loyalCup)
            outStream.close()
        }
    }

    private fun saveOnGoing() {
        val outStream = PrintStream(openFileOutput(ONGOINGFILE, MODE_PRIVATE))
        outStream.print("")
        for (i in 0 until onGoing.size) {
            outStream.println(onGoing[i])
        }
        outStream.close()
    }

    private fun saveHistory() {
        val outStream = PrintStream(openFileOutput(HISTORYFILE, MODE_PRIVATE))
        outStream.print("")
        for (i in 0 until history.size) {
            outStream.println(history[i])
        }
        outStream.close()
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

    override fun onPause() {
        super.onPause()

        saveOnGoing()
        saveHistory()
    }
}