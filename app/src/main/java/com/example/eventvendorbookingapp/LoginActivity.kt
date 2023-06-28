package com.example.eventvendorbookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventvendorbookingapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)
    }
}