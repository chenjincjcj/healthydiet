package com.example.ccccccc

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_zhushi2.*


class ZhushiActivity2 : AppCompatActivity() {
    companion object {
        const val FRUIT_NAME = "zhushi_name"
        const val FRUIT_MSAGE = "zhushi_msage"
        const val FRUIT_IMAGE_ID = "zhushi_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhushi2)
        val zhushiName = intent.getStringExtra(FRUIT_NAME) ?: ""
        val zhushiMsage = intent.getStringExtra(FRUIT_MSAGE) ?: ""
        val zhushiImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar1.title = zhushiName
        Glide.with(this).load(zhushiImageId).into(zhushiImageView)
        zhushiContentText.text = generateFruitContent(zhushiMsage)
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
    private fun generateFruitContent(zhushiName: String) = zhushiName

}