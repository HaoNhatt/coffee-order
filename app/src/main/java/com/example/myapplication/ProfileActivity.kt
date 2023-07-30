package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import java.io.PrintStream
import java.util.Scanner

class ProfileActivity : AppCompatActivity() {
    private val USERINFOFILE = "user_info.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setEdit()
        loadUserInfo()
    }

    private fun loadUserInfo() {
        val reader = Scanner(openFileInput(USERINFOFILE))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
            val userData = line.split("\t")
            findViewById<EditText>(R.id.user_name).setText(userData[0])
            findViewById<EditText>(R.id.user_phone).setText(userData[1])
            findViewById<EditText>(R.id.user_email).setText(userData[2])
            findViewById<EditText>(R.id.user_address).setText(userData[3])
        }
    }

    private fun saveUserInfo() {
        val line = "${findViewById<EditText>(R.id.user_name).text}\t" +
                "${findViewById<EditText>(R.id.user_phone).text}\t" +
                "${findViewById<EditText>(R.id.user_email).text}\t" +
                "${findViewById<EditText>(R.id.user_address).text}"
        val outStream = PrintStream(openFileOutput(USERINFOFILE, MODE_PRIVATE))
        outStream.println(line)
        outStream.close()
    }

    override fun onPause() {
        super.onPause()

        saveUserInfo()
    }


    private fun setEdit() {
        val editName = findViewById<EditText>(R.id.user_name)
        editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editName.clearFocus()
            }
            false
        }
        val editPhone = findViewById<EditText>(R.id.user_phone)
        editPhone.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editPhone.clearFocus()
            }
            false
        }
        val editEmail = findViewById<EditText>(R.id.user_email)
        editEmail.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editEmail.clearFocus()
            }
            false
        }
        val editAddress = findViewById<EditText>(R.id.user_address)
        editAddress.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editAddress.clearFocus()
            }
            false
        }
    }


    fun focusEditText(view: View) {
        when (view) {
            findViewById<ImageButton>(R.id.edit_name) -> {
                val editName = findViewById<EditText>(R.id.user_name)
                editName.setText("")
                editName.requestFocus()
                showSoftKeyboard(editName)
            }
            findViewById<ImageButton>(R.id.edit_phone) -> {
                val editPhone = findViewById<EditText>(R.id.user_phone)
                editPhone.setText("")
                editPhone.requestFocus()
                showSoftKeyboard(editPhone)
            }
            findViewById<ImageButton>(R.id.edit_email) -> {
                val editEmail = findViewById<EditText>(R.id.user_email)
                editEmail.setText("")
                editEmail.requestFocus()
                showSoftKeyboard(editEmail)
            }
            findViewById<ImageButton>(R.id.edit_address) -> {
                val editAddress = findViewById<EditText>(R.id.user_address)
                editAddress.setText("")
                editAddress.requestFocus()
                showSoftKeyboard(editAddress)
            }
        }
    }

    private fun showSoftKeyboard(view: View) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun actionBack(view: View) {
        saveUserInfo()
        finish()
    }
}