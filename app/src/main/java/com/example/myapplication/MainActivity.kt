package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadSplashscreen()
    }

    private fun loadSplashscreen() {
        setContentView(R.layout.splash_screen)
        //setup variable

//        repeat(4) {
//            Thread.sleep(3000L)
//        }
        loadHomePage()
    }

    private fun loadHomePage() {
        setContentView(R.layout.home_page)
    }

    private fun goToHomePage(view: View) {
        loadHomePage()
    }

    fun goToCart(view: View) {

    }

    fun goToProfile(view: View) {

    }

    fun goToReward(view: View) {

    }

    fun goToMyOrder(view: View) {

    }

    fun details(view: View) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }
}