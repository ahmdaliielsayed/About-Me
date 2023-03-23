package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName = MyName("Ahmed Ali")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        /*findViewById<Button>(R.id.btn_done).setOnClickListener {
            addNickname(it)
        }*/
        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        /*val editTxtNickName = findViewById<EditText>(R.id.edit_txt_nickname)
        val txtNickname = findViewById<TextView>(R.id.txt_nickname)

        txtNickname.text = editTxtNickName.text
        editTxtNickName.visibility = View.GONE
        view.visibility = View.GONE
        txtNickname.visibility = View.VISIBLE*/
        binding.apply {
//            txtNickname.text = editTxtNickname.text
            myName?.nickname = editTxtNickname.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            editTxtNickname.visibility = View.GONE
            view.visibility = View.GONE
            txtNickname.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
