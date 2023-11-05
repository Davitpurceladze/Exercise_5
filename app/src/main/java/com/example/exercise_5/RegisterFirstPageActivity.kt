package com.example.exercise_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise_5.databinding.ActivityRegisterFirstPageBinding

class RegisterFirstPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterFirstPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBackToHomePage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, RegisterSecondPageActivity::class.java)
            startActivity(intent)
        }

    }
}