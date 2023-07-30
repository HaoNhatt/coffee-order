package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    private var amount = 1
    private var shot = "Single"
    private var select = "Ice"
    private var size = "Medium"
    private var ice = "Large"
    private var basePrice_m = 2.50
    private var basePrice_l = 3.00
    private var basePrice_xl = 3.50
    private var total_price = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setOption()
        setImageAndDes()
    }

    private fun setImageAndDes() {
        if (intent != null) {
            val drinkName = findViewById<TextView>(R.id.drink_name)
            val drinkID = intent.getStringExtra("id") ?: "Americano"
            when (drinkID.lowercase()) {
                "americano" -> {
                    drinkName.text = getString(R.string.americano)
                }
                "cappuccino" -> {
                    drinkName.text = getString(R.string.cappuccino)
                }
                "mocha" -> {
                    drinkName.text = getString(R.string.mocha)
                }
                "flat_white" -> {
                    drinkName.text = getString(R.string.flat_white)
                }
            }
            val imageID = findViewById<ImageView>(R.id.drink_detail_image)
            imageID.setImageResource(resources.getIdentifier(drinkID.lowercase(), "drawable", packageName))
        }
    }

    private fun setOption() {
        amount = 1
        shot = "Single"
        select = "Ice"
        size = "Medium"
        ice = "Large"
        basePrice_m = 2.50
        basePrice_l = 3.00
        basePrice_xl = 3.50
        total_price = amount * basePrice_l
    }

    fun actionBack(view: View) {
        finish()
    }

    fun setAmount(view: View) {
        when (view.tag) {
            "increase" -> {
                amount += 1
                findViewById<TextView>(R.id.drink_current_amount).text = amount.toString()
            }
            "decrease" -> {
                if (amount > 1) {
                    amount -= 1
                    findViewById<TextView>(R.id.drink_current_amount).text = amount.toString()
                }
            }
        }
        updateTotalAmount()
    }

    fun setShot(view: View) {
        when (view.tag) {
            "single" -> {
                shot = "Single"
                findViewById<RelativeLayout>(R.id.option_single).setBackgroundResource(R.drawable.text_border_selected)
                findViewById<RelativeLayout>(R.id.option_single).setPadding(55, 35, 55, 45)
                findViewById<RelativeLayout>(R.id.option_double).setBackgroundResource(R.drawable.text_border)
                findViewById<RelativeLayout>(R.id.option_double).setPadding(55, 35, 55, 45)
            }
            "double" -> {
                shot = "Double"
                findViewById<RelativeLayout>(R.id.option_double).setBackgroundResource(R.drawable.text_border_selected)
                findViewById<RelativeLayout>(R.id.option_double).setPadding(55, 35, 55, 45)
                findViewById<RelativeLayout>(R.id.option_single).setBackgroundResource(R.drawable.text_border)
                findViewById<RelativeLayout>(R.id.option_single).setPadding(55, 35, 55, 45)
            }
        }
    }

    fun setSelect(view: View) {
        when (view.tag) {
            "hot" -> {
                select = "Hot"
                findViewById<ImageButton>(R.id.option_hot).setImageResource(R.drawable.hot_selected)
                findViewById<ImageButton>(R.id.option_ice).setImageResource(R.drawable.ice)
            }
            "ice" -> {
                select = "Ice"
                findViewById<ImageButton>(R.id.option_ice).setImageResource(R.drawable.ice_selected)
                findViewById<ImageButton>(R.id.option_hot).setImageResource(R.drawable.hot)
            }
        }
    }

    fun setSize(view: View) {
        when (view.tag) {
            "size_m" -> {
                size = "Small"
                findViewById<ImageButton>(R.id.option_size_m).setImageResource(R.drawable.size_m_selected)
                findViewById<ImageButton>(R.id.option_size_l).setImageResource(R.drawable.size_l)
                findViewById<ImageButton>(R.id.option_size_xl).setImageResource(R.drawable.size_xl)
            }
            "size_l" -> {
                size = "Medium"
                findViewById<ImageButton>(R.id.option_size_m).setImageResource(R.drawable.size_m)
                findViewById<ImageButton>(R.id.option_size_l).setImageResource(R.drawable.size_l_selected)
                findViewById<ImageButton>(R.id.option_size_xl).setImageResource(R.drawable.size_xl)
            }
            "size_xl" -> {
                size = "Large"
                findViewById<ImageButton>(R.id.option_size_m).setImageResource(R.drawable.size_m)
                findViewById<ImageButton>(R.id.option_size_l).setImageResource(R.drawable.size_l)
                findViewById<ImageButton>(R.id.option_size_xl).setImageResource(R.drawable.size_xl_selected)
            }
        }
        updateTotalAmount()
    }

    fun setIce(view: View) {
        when (view.tag) {
            "little_ice" -> {
                ice = "Little"
                findViewById<ImageButton>(R.id.option_ice_little).setImageResource(R.drawable.ice_little_selected)
                findViewById<ImageButton>(R.id.option_ice_medium).setImageResource(R.drawable.ice_medium)
                findViewById<ImageButton>(R.id.option_ice_large).setImageResource(R.drawable.ice_large)
            }
            "medium_ice" -> {
                ice = "Medium"
                findViewById<ImageButton>(R.id.option_ice_little).setImageResource(R.drawable.ice_little)
                findViewById<ImageButton>(R.id.option_ice_medium).setImageResource(R.drawable.ice_medium_selected)
                findViewById<ImageButton>(R.id.option_ice_large).setImageResource(R.drawable.ice_large)
            }
            "large_ice" -> {
                ice = "Large"
                findViewById<ImageButton>(R.id.option_ice_little).setImageResource(R.drawable.ice_little)
                findViewById<ImageButton>(R.id.option_ice_medium).setImageResource(R.drawable.ice_medium)
                findViewById<ImageButton>(R.id.option_ice_large).setImageResource(R.drawable.ice_large_selected)
            }
        }
    }

    private fun updateTotalAmount() {
        when (size) {
            "Small" -> {
                total_price = amount * basePrice_m
                findViewById<TextView>(R.id.total_amount).text = buildString {
        append("$")
        append((total_price).toString())
    }
            }
            "Medium" -> {
                total_price = amount * basePrice_l
                findViewById<TextView>(R.id.total_amount).text = buildString {
        append("$")
        append((total_price).toString())
    }
            }
            "Large" -> {
                total_price = amount * basePrice_xl
                findViewById<TextView>(R.id.total_amount).text = buildString {
        append("$")
        append((total_price).toString())
    }
            }
        }
    }

    fun actionGoToMyCart(view: View) {
        val intent = Intent(this, MyCartActivity::class.java)
        startActivity(intent)
    }

    fun actionAddToCart(view: View) {
        val drinkName = intent.getStringExtra("id")
        val intent = Intent(this, MyCartActivity::class.java)
        intent.putExtra("id", drinkName)
        intent.putExtra("amount", amount.toString())
        intent.putExtra("shot", shot)
        intent.putExtra("select", select)
        intent.putExtra("size", size)
        intent.putExtra("ice", ice)
        intent.putExtra("totalPrice", total_price.toString())
        startActivity(intent)
        finish()
    }
}