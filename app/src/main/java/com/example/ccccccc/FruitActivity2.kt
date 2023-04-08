package com.example.ccccccc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_fruit2.*

class FruitActivity2 : AppCompatActivity() {
    companion object {
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_MSAGE = "fruit_msage"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit2)
        val fruitName = intent.getStringExtra(FRUIT_NAME) ?: ""
        val fruitMsage = intent.getStringExtra(FRUIT_MSAGE) ?: ""
        val fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(fruitImageView)
        fruitContentText.text = generateFruitContent(fruitMsage)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun generateFruitContent(fruitName: String) = fruitName.repeat(1)

}