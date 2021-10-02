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

            val  superheroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating

            openDatailActivity(superheroName, alterEgo, bio, power)
        }
    }

    private fun openDatailActivity(superheroName: String, alterEgo: String, bio: String, power: Float) {
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra(DetailActivity.SUPERHERO_NAME_KEY, superheroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(DetailActivity.BIO_KEY, bio)
        intent.putExtra(DetailActivity.POWER_KEY, power)

        startActivity(intent)
    }
}