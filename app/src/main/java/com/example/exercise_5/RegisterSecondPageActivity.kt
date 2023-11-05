package com.example.exercise_5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.exercise_5.databinding.ActivityRegisterSecondPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterSecondPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterSecondPageBinding
    private lateinit  var email: String
    private lateinit  var password: String
    private lateinit var username: String
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        email = intent.getStringExtra("email").toString()
        password = intent.getStringExtra("password").toString()
        val progressBar = binding.progressBar


        binding.btnBackToRegisterFirstPage.setOnClickListener {
            val intent = Intent(this, RegisterFirstPageActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUp.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            if(usernameValidation()){


                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        progressBar.visibility = View.GONE
                        if (task.isSuccessful) {

                            Toast.makeText(
                                baseContext,
                                "Account Created.",
                                Toast.LENGTH_SHORT,
                            ).show()
                            val intent = Intent(this, LogInPageActivity::class.java)
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }

            } else return@setOnClickListener

        }
    }

    private fun usernameValidation(): Boolean {
        val usernameValue: Editable? = binding.etUsername.text
        username = usernameValue.toString()

        return if(username.length >= 6) {
            true
        } else {
            Toast.makeText(this, "Username have to be more than 6 character", Toast.LENGTH_LONG).show()
            false
        }
    }
}