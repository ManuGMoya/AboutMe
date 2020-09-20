package com.manugmoya.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners(){
        btn_done.setOnClickListener {
            tv_nickname.text = ed_name.text.toString()
            tv_nickname.visibility = View.VISIBLE
            btn_done.visibility = View.GONE
            ed_name.visibility = View.GONE

            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }

        tv_nickname.setOnClickListener{
            ed_name.visibility = View.VISIBLE
            btn_done.visibility = View.VISIBLE
            tv_nickname.visibility = View.GONE
            ed_name.requestFocus()

            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(ed_name, 0)
        }

    }
}