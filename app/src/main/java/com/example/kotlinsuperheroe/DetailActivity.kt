package com.example.kotlinsuperheroe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinsuperheroe.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val SUPERHERO_NAME_KEY = "superhero_name"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO_KEY = "bio"
        const val POWER_KEY = "power"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bundle = intent.extras!!

        val superheroeName = bundle.getString(SUPERHERO_NAME_KEY) ?: ""
        val alterEgo = bundle.getString(ALTER_EGO_KEY) ?: ""
        val bio = bundle.getString(BIO_KEY) ?: ""
        val power = bundle.getFloat(POWER_KEY)

        binding.heroName.text = superheroeName
        binding.alterEgoText.text = alterEgo
        binding.bioText2.text = bio
        binding.ratingBar.rating = power
    }
}