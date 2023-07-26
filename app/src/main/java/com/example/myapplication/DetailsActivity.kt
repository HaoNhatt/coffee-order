package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailsActivity : AppCompatActivity() {
    private val amount = 1
    private val shot = "Single"
    private val select = "Ice"
    private val size = "Medium"
    private val ice = "Large"
    private val basePrice = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    fun actionBack(view: View) {
        finish()
    }

    fun setAmount(view: View) {

    }

    fun setShot(view: View) {

    }

    fun setSelect(view: View) {

    }

    fun setSize(view: View) {

    }

    fun setIce(view: View) {

    }

    fun actionAddToCart(view: View) {
        val intent = Intent(this, MyCartActivity::class.java)
        intent.putExtra("amount", amount)
        intent.putExtra("shot", shot)
        intent.putExtra("select", select)
        intent.putExtra("size", size)
        intent.putExtra("ice", ice)
        intent.putExtra("basePrice", basePrice)
        startActivity(intent)
    }
}