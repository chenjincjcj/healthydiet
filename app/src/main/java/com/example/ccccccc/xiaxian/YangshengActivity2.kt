
package com.example.ccccccc.xiaxian

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.ccccccc.PengrenActivity2
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_fruit2.*
import kotlinx.android.synthetic.main.activity_fruit2.toolbar
import kotlinx.android.synthetic.main.activity_pengren2.*
import kotlinx.android.synthetic.main.activity_pengren2.pause
import kotlinx.android.synthetic.main.activity_pengren2.play
import kotlinx.android.synthetic.main.activity_pengren2.replay
import kotlinx.android.synthetic.main.activity_yangsheng2.*

class YangshengActivity2 : AppCompatActivity() {
    companion object {
        const val YANGSHENG_NAME = "yangsheng_name"
        const val YANGSHENG_MSAGE = "yangsheng_msage"
        const val YANGSHENG_VOID_ID = "yangsheng_voidid"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yangsheng2)
        val yangshengName = intent.getStringExtra(YangshengActivity2.YANGSHENG_NAME) ?: ""
        val yangshengMsage = intent.getStringExtra(YangshengActivity2.YANGSHENG_MSAGE) ?: ""
        val yangshengVoide = intent.getStringExtra(YangshengActivity2.YANGSHENG_VOID_ID) ?: ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        yangshengToolbar.title =yangshengName
        val uri: Uri = yangshengVoide.toUri()
        yangshengvoideView.setVideoURI(uri)
        yangshengContentText.text=yangshengMsage
        play.setOnClickListener {
            if (!yangshengvoideView.isPlaying) {

                yangshengvoideView.start() // 开始播放
            }
        }
        pause.setOnClickListener {
            if (yangshengvoideView.isPlaying) {
                yangshengvoideView.pause() // 暂停播放
            }
        }
        replay.setOnClickListener {
            if (yangshengvoideView.isPlaying) {
                yangshengvoideView.resume() // 重新播放
            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        yangshengvoideView.suspend()
    }

}