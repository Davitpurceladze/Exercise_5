package com.example.exercise_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.exercise_5.databinding.ActivityRegisterFirstPageBinding

class RegisterFirstPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterFirstPageBinding
    private lateinit  var email: String
    private lateinit  var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToHomePage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {

            if(emailValidation() && passwordValidation()){
                val intent = Intent(this, RegisterSecondPageActivity::class.java)
                // send email and password to RegisterSecondPageActivity
                intent.putExtra("email", email  )
                intent.putExtra("password", password  )

                startActivity(intent)
            }

        }

    }

    private fun emailValidation(): Boolean {
        val emailValue: Editable? = binding.etEmail.text
        email = emailValue.toString()

        return if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            true
        } else {
            Toast.makeText(this, "Email example: example@gmail.com", Toast.LENGTH_LONG).show()
            false
        }
    }

    private fun passwordValidation(): Boolean {
        val passwordValue: Editable? = binding.etPassword.text
        password = passwordValue.toString()

        return if(password.length >= 8) {
            true
        } else {
            Toast.makeText(this, "Password have to be 8 or more characters!", Toast.LENGTH_LONG).show()
            false
        }
    }
}