package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
        goToHomePage()
    }

    private fun goToHomePage() {
        setContentView(R.layout.home_page)
    }

    fun goToCart() {

    }

    fun goToProfile() {

    }

    fun goToReward() {

    }

    fun goToMyOrder() {

    }
}