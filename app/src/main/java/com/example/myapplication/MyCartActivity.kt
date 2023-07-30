package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text
import java.io.PrintStream
import java.util.Scanner

class MyCartActivity : AppCompatActivity() {
    private var arrayDrink = arrayListOf<String>()
    private var total_price = 0.0
    private val CARTFILE = "cart.txt"
    private val ONGOINGFILE = "on_going.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        setupDrink()
        addDrinkCart()
    }

    private fun setupDrink() {
        if (intent.hasExtra("id")) {
            arrayDrink.add(
                "${intent.getStringExtra("id")}\t" +
                "${intent.getStringExtra("amount")}\t" +
                "${intent.getStringExtra("shot")}\t" +
                "${intent.getStringExtra("select")}\t" +
                "${intent.getStringExtra("size")}\t" +
                "${intent.getStringExtra("ice")}\t" +
                "${intent.getStringExtra("totalPrice")}"
            )
        }

        loadCart()

        for (i in 0 until arrayDrink.size) {
            val drink = arrayDrink[i]
            val drinkDetails = drink.split("\t")
            total_price += drinkDetails[6].toDouble()
        }
        findViewById<TextView>(R.id.total_amount).text = buildString {
            append("$")
            append(total_price.toString())
        }
    }

    private fun loadCart() {
        val reader = Scanner(openFileInput(CARTFILE))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            arrayDrink.add(line)
        }
    }

    private fun addDrinkCart() {
        for (i in 0 until arrayDrink.size) {
            val drink = arrayDrink[i]
            val drinkDetails = drink.split("\t")
            val drinkCart = layoutInflater.inflate(R.layout.cart_drink, null)
            val drinkImage = resources.getIdentifier(drinkDetails[0].lowercase(), "drawable", packageName)
            drinkCart.findViewById<ImageView>(R.id.drink_image).setImageResource(drinkImage)
            drinkCart.findViewById<TextView>(R.id.drink_name).text = drinkDetails[0]
            drinkCart.findViewById<TextView>(R.id.drink_description).text = buildString {
                append(drinkDetails[2])
                append(" | ")
                append(drinkDetails[3])
                append(" | ")
                append(drinkDetails[4])
                append(" | ")
                append(drinkDetails[5])
            }
            drinkCart.findViewById<TextView>(R.id.drink_amount).text = buildString {
                append("X ")
                append(drinkDetails[1])
            }
            drinkCart.findViewById<TextView>(R.id.drink_price).text = buildString {
                append("$")
                append(drinkDetails[6])
            }
            findViewById<LinearLayout>(R.id.linear_layout_cart).addView(drinkCart)
        }
    }

    fun goToOrderSuccess(view: View) {
        addToGoing()
        val intent = Intent(this, OrderSuccessActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goBack(view: View) {
        saveCart()
        finish()
    }

    private fun saveCart() {
        val outStream = PrintStream(openFileOutput(CARTFILE, MODE_PRIVATE))
        for (i in 0 until arrayDrink.size) {
            val drinkDetail = arrayDrink[i]
            outStream.println(drinkDetail)
        }
        outStream.close()
    }

    private fun addToGoing() {
        var outStream = PrintStream(openFileOutput(CARTFILE, MODE_PRIVATE))
        outStream.print("")
        outStream.close()
        outStream = PrintStream(openFileOutput(ONGOINGFILE, MODE_PRIVATE))
        outStream.print("")
        for (i in 0 until arrayDrink.size) {
            val drinkDetail = arrayDrink[i]
            outStream.println(drinkDetail)
        }
        outStream.close()
    }
}