package com.example.eventvendorbookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventvendorbookingapp.databinding.ActivityVendorFormBinding

class VendorForm : AppCompatActivity() {
    lateinit var vendorFormBindng:ActivityVendorFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vendorFormBindng = ActivityVendorFormBinding.inflate(layoutInflater)
        val view = vendorFormBindng.root
        setContentView(view)
        vendorFormBindng.submitButton.setOnClickListener {
            val intent = Intent(this@VendorForm, MainActivity::class.java)
            startActivity(intent)
        }
    }
}