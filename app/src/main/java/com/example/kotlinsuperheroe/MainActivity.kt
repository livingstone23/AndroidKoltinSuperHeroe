package com.example.kotlinsuperheroe

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.example.kotlinsuperheroe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.saveButton.setOnClickListener{

            val  superheroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating

            //openDatailActivity(superheroName, alterEgo, bio, power)

            val hero = Superhero(superheroName, alterEgo, bio, power)
            openDatailActivity(hero)
        }

        heroImage = binding.heroImage

        heroImage.setOnClickListener{
            openCamera()
        }



        binding.heroImage.setOnClickListener{
            openCamera()
        }



    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 1000)
    }

    /*
    private fun openDatailActivity(superheroName: String, alterEgo: String, bio: String, power: Float) {
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra(DetailActivity.SUPERHERO_NAME_KEY, superheroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(DetailActivity.BIO_KEY, bio)
        intent.putExtra(DetailActivity.POWER_KEY, power)
        startActivity(intent)
    }
    */

    private fun openDatailActivity(superhero: Superhero) {
        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        intent.putExtra(DetailActivity.BITMAP_KEY, heroImage.drawable.toBitmap())

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 1000)
        {
            val extras = data?.extras
            val heroBitmap = extras?.getParcelable<Bitmap>("data")
            heroImage.setImageBitmap(heroBitmap)
        }
    }



}