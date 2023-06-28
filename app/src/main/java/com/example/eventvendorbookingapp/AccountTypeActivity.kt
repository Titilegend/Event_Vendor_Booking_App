package com.example.eventvendorbookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventvendorbookingapp.databinding.ActivityAccountTypeBinding

class AccountTypeActivity : AppCompatActivity() {
    lateinit var accountTypeBinding:ActivityAccountTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accountTypeBinding = ActivityAccountTypeBinding.inflate(layoutInflater)
        val view = accountTypeBinding.root
        setContentView(view)
        accountTypeBinding.eventVendorButton.setOnClickListener {
            val intent = Intent(this@AccountTypeActivity, VendorForm::class.java)
            startActivity(intent)
        }
    }
}