package com.example.eventvendorbookingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.eventvendorbookingapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    lateinit var signupBinding:ActivitySignUpBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signupBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signupBinding.root
        setContentView(view)
        signupBinding.buttonSignUp.setOnClickListener {
            val email = signupBinding.emailSignUp.text.toString()
            val password = signupBinding.passwordSignUp.text.toString()
            signinUser(email, password)
            val intent = Intent(this@SignUpActivity, AccountTypeActivity::class.java)
            startActivity(intent)

        }
        signupBinding.textViewLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun signinUser(email: String, userPassword: String) {
        signupBinding.progressBar.visibility = View.VISIBLE
        signupBinding.buttonSignUp.isClickable = false


        auth.createUserWithEmailAndPassword(email, userPassword).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                user?.let {
                    val userId = it.uid
                    // Save user details to Firestore
                    //saveUserDetailsToFirestore(userId, email, userPassword)
                    Toast.makeText(
                        applicationContext,
                        "Your account has been created",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()

                    signupBinding.progressBar.visibility = View.INVISIBLE
                    signupBinding.buttonSignUp.isClickable = true


                }
            }; else {
                Toast.makeText(
                    applicationContext,
                    task.exception?.localizedMessage,
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
    }

}