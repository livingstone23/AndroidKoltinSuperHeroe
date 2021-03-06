package com.example.kotlinsuperheroe

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinsuperheroe.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    /*
    companion object {
        const val SUPERHERO_NAME_KEY = "superhero_name"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO_KEY = "bio"
        const val POWER_KEY = "power"

    }
    */

    companion object {
        const val SUPERHERO_KEY = "superhero"
        const val BITMAP_KEY = "bitmap"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bundle = intent.extras!!

        /*
        val superheroeName = bundle.getString(SUPERHERO_NAME_KEY) ?: ""
        val alterEgo = bundle.getString(ALTER_EGO_KEY) ?: ""
        val bio = bundle.getString(BIO_KEY) ?: ""
        val power = bundle.getFloat(POWER_KEY)
        */

        val superhero = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!
        val bitmapDirectory = bundle.getString(BITMAP_KEY)!!

        val bitmap = BitmapFactory.decodeFile(bitmapDirectory)
        //val bitmap = bundle.getParcelable<Bitmap>(BITMAP_KEY)!!

        /*
        binding.heroName.text = superheroeName
        binding.alterEgoText.text = alterEgo
        binding.bioText2.text = bio
        binding.ratingBar.rating = power
        */

        /*
        binding.heroName.text = superhero.name
        binding.alterEgoText.text = superhero.alterEgo
        binding.bioText2.text = superhero.bio
        binding.ratingBar.rating = superhero.power
        */

        binding.imageView.setImageBitmap(bitmap)
        binding.superheroe = superhero

    }
}