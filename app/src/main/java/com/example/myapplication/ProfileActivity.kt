package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setEdit()
    }

    private fun setEdit() {
        val editName = findViewById<EditText>(R.id.user_name)
        editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editName.clearFocus()
                val newName = editName.text.toString()
                Log.d("HaoNhatTest", newName)
            }
            false
        }
        val editPhone = findViewById<EditText>(R.id.user_phone)
        editPhone.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editPhone.clearFocus()
                val newPhone = editPhone.text.toString()
                Log.d("HaoNhatTest", newPhone)
            }
            false
        }
        val editEmail = findViewById<EditText>(R.id.user_email)
        editEmail.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editEmail.clearFocus()
                val newEmail = editName.text.toString()
                Log.d("HaoNhatTest", newEmail)
            }
            false
        }
        val editAddress = findViewById<EditText>(R.id.user_address)
        editName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                editName.clearFocus()
                val newAddress = editName.text.toString()
                Log.d("HaoNhatTest", newAddress)
            }
            false
        }
    }

//    fun releaseFocus(view: View) {
//        Log.d("HaoNhatTest", "$currentFocus")
//        currentFocus?.clearFocus()
//        Log.d("HaoNhatTest", "$currentFocus")
//    }

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