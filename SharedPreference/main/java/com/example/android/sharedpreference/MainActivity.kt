package com.example.android.sharedpreferences

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.android.sharedpreference.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        if (checkbox.isChecked) {

            val name = etName.text.toString()
            val password = etPassword.text.toString()

            editor.apply {
                putString("name", name)
                putString("password", password)
                apply()
            }

        }

        btnLoad.setOnClickListener{
            val name = sharedPref.getString("name", null)
            val password = sharedPref.getString("password", null)

            etName.setText(name)
            etPassword.setText(password)

            if (checkbox.isChecked){
                checkbox.isChecked = true
            }
            checkbox.isChecked = false
        }

    }
}