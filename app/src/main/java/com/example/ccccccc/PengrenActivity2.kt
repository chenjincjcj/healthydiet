package com.example.ccccccc

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_fruit2.*
import kotlinx.android.synthetic.main.activity_fruit2.toolbar
import kotlinx.android.synthetic.main.activity_pengren2.*
import kotlinx.android.synthetic.main.activity_shucai2.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.pengren_item.*
import retrofit2.http.Url
import java.io.File

class PengrenActivity2 : AppCompatActivity() {
    companion object {
        const val PENGREN_NAME = "pengren_name"
        const val PENGREN_MSAGE = "pengren_msage"
        const val PENGREN_VOID_ID = "pengren_voidid"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengren2)
        val pengrenName = intent.getStringExtra(PENGREN_NAME) ?: ""
        val pengrenMsage = intent.getStringExtra(PENGREN_MSAGE) ?: ""
        val pengrennVoide = intent.getStringExtra(PENGREN_VOID_ID) ?: ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        pengrenToolbar.title = pengrenName
        val uri:Uri = pengrennVoide.toUri()
        pengrenvoideView.setVideoURI(uri)
        pengrenContentText.text=pengrenMsage
        play.setOnClickListener {
            if (!pengrenvoideView.isPlaying) {

                pengrenvoideView.start() // 开始播放
            }
        }
        pause.setOnClickListener {
            if (pengrenvoideView.isPlaying) {
                pengrenvoideView.pause() // 暂停播放
            }
        }
        replay.setOnClickListener {
            if (pengrenvoideView.isPlaying) {
                pengrenvoideView.resume() // 重新播放
            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        pengrenvoideView.suspend()
    }

}


