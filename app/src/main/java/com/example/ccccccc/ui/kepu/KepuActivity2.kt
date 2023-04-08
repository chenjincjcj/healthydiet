package com.example.ccccccc.ui.kepu

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.ccccccc.FruitActivity2
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_fruit2.*
import kotlinx.android.synthetic.main.activity_fruit2.collapsingToolbar
import kotlinx.android.synthetic.main.activity_fruit2.toolbar
import kotlinx.android.synthetic.main.activity_kepu2.*
import kotlinx.android.synthetic.main.activity_kepu2.pause
import kotlinx.android.synthetic.main.activity_kepu2.play
import kotlinx.android.synthetic.main.activity_kepu2.replay
import kotlinx.android.synthetic.main.activity_pengren2.*

class KepuActivity2 : AppCompatActivity() {
    companion object {
        const val KEPU_NAME = "kepu_name"
        const val KEPU_MSAGE = "kepu_msage"
        const val KEPU_VOID_ID = "kepu_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kepu2)
        val kepuName = intent.getStringExtra(KepuActivity2.KEPU_NAME) ?: ""
        val kepuMsage = intent.getStringExtra(KepuActivity2.KEPU_MSAGE) ?: ""
        val kepuVoide = intent.getStringExtra(KepuActivity2.KEPU_VOID_ID)?:""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        kepuToolbar.title = kepuName
        val uri: Uri = kepuVoide.toUri()
        kepuvoideView.setVideoURI(uri)
        kepuContentText.text=kepuMsage
        play.setOnClickListener {
            if (!kepuvoideView.isPlaying) {

                kepuvoideView.start() // 开始播放
            }
        }
        pause.setOnClickListener {
            if (kepuvoideView.isPlaying) {
                kepuvoideView.pause() // 暂停播放
            }
        }
        replay.setOnClickListener {
            if (kepuvoideView.isPlaying) {
                kepuvoideView.resume() // 重新播放
            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        kepuvoideView.suspend()
    }

}


