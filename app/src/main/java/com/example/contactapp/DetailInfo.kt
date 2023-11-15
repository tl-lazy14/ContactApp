package com.example.contactapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi

class DetailInfo : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_info)
        val user: User? = intent.getParcelableExtra("user", User::class.java)
        val userId = user?.getUserID()
        val username = user?.getUserName()
        val phone = user?.getUserPhone()
        val email = user?.getUserEmail()

        val tvUserID = findViewById<TextView>(R.id.tvUserID)
        tvUserID.text = userId

        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        tvUserName.text = username

        val tvUserPhone = findViewById<TextView>(R.id.tvUserPhone)
        tvUserPhone.text = phone

        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        tvUserEmail.text = email

        val backIcon: ImageView = findViewById(R.id.backIcon)
        backIcon.setOnClickListener {
            finish()
        }
    }
}