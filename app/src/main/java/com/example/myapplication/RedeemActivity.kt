package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.PrintStream
import java.util.Scanner

class RedeemActivity : AppCompatActivity() {
    private val REDEEMFILE = "user_redeem.txt"
    private val ONGOINGFILE = "on_going.txt"
    private var redeemPoint = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem)

        setupPoints()
    }

    private fun setupPoints() {
        val reader = Scanner(openFileInput(REDEEMFILE))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            redeemPoint = line.toInt()
        }
    }

    fun actionBack(view: View) {
        savePoint()
        finish()
    }

    fun actionRedeemDrink(view: View) {
        if (redeemPoint >= 1340) {
            val outStream = PrintStream(openFileOutput(ONGOINGFILE, MODE_APPEND))
            outStream.println("${view.tag}\t1\tSingle\tIce\tMedium\tLarge\t" + 3.0)
            outStream.close()
            redeemPoint -= 1340
            savePoint()
            setupPoints()
            val intent = Intent(this, MyOrderActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            Toast.makeText(this, "You don't have enough points", Toast.LENGTH_SHORT).show()
        }
    }

    private fun savePoint() {
        val outStream = PrintStream(openFileOutput(REDEEMFILE, MODE_PRIVATE))
        outStream.println(redeemPoint)
        outStream.close()
    }

    override fun onPause() {
        super.onPause()

        savePoint()
    }
}