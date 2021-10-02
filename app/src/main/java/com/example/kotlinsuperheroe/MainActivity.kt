package com.example.kotlinsuperheroe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinsuperheroe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            openDatailActivity()
        }
    }

    private fun openDatailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}