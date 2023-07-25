package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
//    var myCart =
//    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//        if (event.action == MotionEvent.ACTION_DOWN) {
//            val v = currentFocus
//            if (v is EditText) {
//                val outRect = Rect()
//                v.getGlobalVisibleRect(outRect)
//                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
//                    Log.d("focus", "touchevent")
//                    v.clearFocus()
//                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
//                }
//            }
//        }
//        return super.dispatchTouchEvent(event)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadSplashscreen()
    }

    private fun loadSplashscreen() {
        setContentView(R.layout.splash_screen)

//        repeat(4) {
//            Thread.sleep(3000L)
//        }
        loadHomePage()
    }

    private fun loadHomePage() {
        setContentView(R.layout.home_page)
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
        findViewById<TextView>(R.id.loyal_cup).text = "$loyalCup / 8"
    }

    fun goToHomePage(view: View) {
        loadHomePage()
    }

    fun goToCart(view: View) {
        setContentView(R.layout.my_cart)
    }

    fun goToProfile(view: View) {
        setContentView(R.layout.profile)
        val editName = findViewById<EditText>(R.id.user_name)
        editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editName.clearFocus()
                val newName = editName.text.toString()
                Log.d("HaoNhatTest", "$newName")
            }
            false
        }
        val editPhone = findViewById<EditText>(R.id.user_phone)
        editPhone.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editPhone.clearFocus()
                val newPhone = editPhone.text.toString()
                Log.d("HaoNhatTest", "$newPhone")
            }
            false
        }
        val editEmail = findViewById<EditText>(R.id.user_email)
        editEmail.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editEmail.clearFocus()
                val newEmail = editName.text.toString()
                Log.d("HaoNhatTest", "$newEmail")
            }
            false
        }
        val editAddress = findViewById<EditText>(R.id.user_address)
        editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editName.clearFocus()
                val newAddress = editName.text.toString()
                Log.d("HaoNhatTest", "$newAddress")
            }
            false
        }
    }

//    fun releaseFocus(view: View) {
//        Log.d("HaoNhatTest", "$currentFocus")
//        currentFocus?.clearFocus()
//        Log.d("HaoNhatTest", "$currentFocus")
//    }

    fun goToReward(view: View) {

    }

    fun goToMyOrders(view: View) {
        setContentView(R.layout.my_order)
    }

    fun details(view: View) {
//        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.details)
    }

    fun increaseDetail(view: View) {

    }

    fun decreaseDetail(view: View) {

    }

    fun setOption(view: View) {

    }

    fun addToCart(view: View) {
        goToCart(view)
    }

    fun goToOrderSuccess(view: View) {
        setContentView(R.layout.order_success)
    }

    fun focusEditText(view: View) {
        when (view) {
            findViewById<ImageButton>(R.id.edit_name) -> {
                val editName = findViewById<EditText>(R.id.user_name)
                editName.setText("")
                editName.requestFocus()
                showSoftKeyboard(editName)
            };
            findViewById<ImageButton>(R.id.edit_phone) -> {
                val editPhone = findViewById<EditText>(R.id.user_phone)
                editPhone.setText("")
                editPhone.requestFocus()
                showSoftKeyboard(editPhone)
            };
            findViewById<ImageButton>(R.id.edit_email) -> {
                val editEmail = findViewById<EditText>(R.id.user_email)
                editEmail.setText("")
                editEmail.requestFocus()
                showSoftKeyboard(editEmail)
            };
            findViewById<ImageButton>(R.id.edit_address) -> {
                val editAddress = findViewById<EditText>(R.id.user_address)
                editAddress.setText("")
                editAddress.requestFocus()
                showSoftKeyboard(editAddress)
            };
        }
    }

    private fun showSoftKeyboard(view: View) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}