package com.example.ccccccc.ui.jianshen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.bumptech.glide.Glide
import com.example.ccccccc.R
import com.example.ccccccc.ui.dati.LianjieActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bbbb.*
import kotlinx.android.synthetic.main.activity_jianshenn.*
import kotlinx.android.synthetic.main.activity_jianshenn.pause
import kotlinx.android.synthetic.main.activity_jianshenn.play
import kotlinx.android.synthetic.main.activity_jianshenn.replay
import kotlinx.android.synthetic.main.activity_jianshenn.swipeRefresh
import kotlinx.android.synthetic.main.activity_jinri.*
import kotlinx.android.synthetic.main.activity_pengren2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.concurrent.thread

@Suppress("NAME_SHADOWING")
class JianshennActivity : AppCompatActivity() {
    private val mediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jianshenn)
        val data: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)!!
        val dname=data.getString("name","")
        val  edit= getSharedPreferences("$dname", Context.MODE_PRIVATE).edit()
        val  sp= getSharedPreferences("$dname", Context.MODE_PRIVATE)
        val shangci=sp.getString("jilu","")
da.text=shangci.toString()
        var rangeTime=0
//开始按钮：

        start?.setOnClickListener {
            chronometer.setBase(SystemClock.elapsedRealtime())
            chronometer.start()
        }
//暂停按钮：

        stop?.setOnClickListener {
            rangeTime= (SystemClock.elapsedRealtime()-chronometer.getBase()).toInt().toDouble().toInt()
            chronometer.stop()
            val A=chronometer.text.toString()
            val data: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)!!
            val dname=data.getString("name","")
            Log.d("LOG",A.toString())
            val  edit= getSharedPreferences("$dname", Context.MODE_PRIVATE).edit()
            edit.putString("jilu", A)
            edit.apply()


        }

//继续按钮：

        countinue?.setOnClickListener {
            chronometer.setBase((SystemClock.elapsedRealtime()-rangeTime).toLong())
            chronometer.start()
        }
//重置按钮:

        bun4?.setOnClickListener {
            chronometer.setText("00:00")
            chronometer.setBase(SystemClock.elapsedRealtime())
            chronometer.stop()
        }
        val uri = Uri.parse("android.resource://$packageName/${R.raw.jianshen}")
    jianshenvoideView.setVideoURI(uri)
        play.setOnClickListener {
            if (!jianshenvoideView.isPlaying) {

                jianshenvoideView.start() // 开始播放
            }
        }
        pause.setOnClickListener {
            if (jianshenvoideView.isPlaying) {
                jianshenvoideView.pause() // 暂停播放
            }
        }
        replay.setOnClickListener {
            if (jianshenvoideView.isPlaying) {
                jianshenvoideView.resume() // 重新播放
            }

        }
        refreshFruits()
        swipeRefresh.setColorSchemeResources(R.color.purple_200)
        swipeRefresh.setOnRefreshListener {
            refreshFruits()
        }
        initMediaPlayer()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "音乐播放", Snackbar.LENGTH_SHORT)
                .setAction("开始") {
                    if (!mediaPlayer.isPlaying) {
                        mediaPlayer.start() // 开始播放\
                        Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                    }
                }.show()

        }
        fab1.setOnClickListener { view ->
            Snackbar.make(view, "音乐播放", Snackbar.LENGTH_SHORT)
                .setAction("暂停") {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.reset() // 停止播放
                        initMediaPlayer()
                    }
                }.show()

        }


    }
    private fun initMediaPlayer() {
        val assetManager = assets
        val fd = assetManager.openFd("music.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
    fun refreshFruits() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val JianshenService = retrofit.create(JianshenService::class.java)
                JianshenService.getXuanze().enqueue(object : Callback<List<Jianshen>> {
                    override fun onResponse(
                        call: Call<List<Jianshen>>,
                        response: Response<List<Jianshen>>
                    ) {
                        val list = response.body()
                        if (list != null) {
                            for (jianshen in list) {
                                jiansehnToolbar.title = jianshen.id
                                jiasnhenContentText.text = jianshen.optionA
                                xiangmu.text = jianshen.optionB
                                val image1:String=jianshen.image1
                                Glide.with(this@JianshennActivity).load("$image1").into(xiangmu_image1)
                                val image2:String=jianshen.image2
                                Glide.with(this@JianshennActivity).load("$image2").into(xiangmu_image2)
                                val image3:String=jianshen.image3
                                Glide.with(this@JianshennActivity).load("$image3").into(xiangmu_image3)


                                Log.d("MainActivity", "id is ${jianshen.id}")
                                Log.d("MainActivity", "name is ${jianshen.optionA}")
                                Log.d("MainActivity", "version is ${jianshen.optionB}")
                            }
                        }
                    }


                    override fun onFailure(call: Call<List<Jianshen>>, t: Throwable) {
                        t.printStackTrace()

                    }
                })
                swipeRefresh.isRefreshing = false
            }
        }
    }
}
class Jianshen(val id: String, val optionA: String, val optionB: String,val reslt:String,val image1:String,val image2:String,val image3:String)
interface JianshenService {
    @GET("jianshen.json")
    fun getXuanze(): Call<List<Jianshen>>
}
