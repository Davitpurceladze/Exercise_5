package com.example.exercise_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterFirstPageActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, LogInPageActivity::class.java)
            startActivity(intent)
        }

    }
}