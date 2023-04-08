package com.example.ccccccc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_shucai.*
import kotlinx.android.synthetic.main.activity_shucai.toolbar
import kotlinx.android.synthetic.main.activity_shucai2.*

class ShucaiActivity2 : AppCompatActivity() {
    companion object {
        const val SHUCAI_NAME = "shucai_name"
        const val SHUCAI_MSAGE = "shucai_msage"
        const val SHUCAI_IMAGE_ID = "shucai_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shucai2)
        val shucaiName = intent.getStringExtra(SHUCAI_NAME) ?: ""
        val shucaiMsage = intent.getStringExtra(SHUCAI_MSAGE) ?: ""
        val shucaiImageId = intent.getIntExtra(SHUCAI_IMAGE_ID, 0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title =shucaiName
        Glide.with(this).load(shucaiImageId).into(shucaiImageView)
        shucaiContentText.text = generateFruitContent(shucaiMsage)
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
    private fun generateFruitContent(shucaiName: String) = shucaiName.repeat(1)

}