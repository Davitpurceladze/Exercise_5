package com.example.exercise_5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise_5.databinding.ActivityRegisterSecondPageBinding

class RegisterSecondPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterSecondPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSecondPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToRegisterFirstPage.setOnClickListener {
            val intent = Intent(this, RegisterFirstPageActivity::class.java)
            startActivity(intent)
        }
    }
}