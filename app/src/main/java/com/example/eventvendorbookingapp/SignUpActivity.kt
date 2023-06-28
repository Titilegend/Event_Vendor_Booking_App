package com.example.eventvendorbookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventvendorbookingapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var signupBinding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signupBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signupBinding.root
        setContentView(view)
        signupBinding.buttonSignUp.setOnClickListener {
            val intent = Intent(this@SignUpActivity, AccountTypeActivity::class.java)
            startActivity(intent)
        }
        signupBinding.textViewLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}