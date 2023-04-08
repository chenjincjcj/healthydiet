package com.example.ccccccc.ui.start

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.ccccccc.DengluActivity
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    var thread: timeThread? = null
    //使用handle
    val MSG = 1
    val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            //进行ui操作
            when (msg.what) {
                MSG -> {
                    start_tiaoguo_bt.setText("跳过 " + msg.arg1)
                    if (msg.arg1 <= 0) {
                        //先销毁欢迎界面
                        finish()
                        //去登录界面
                        val intent = Intent(this@StartActivity, DengluActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    // 自定义的线程---控制倒计时
    inner class timeThread : Thread() {
        override fun run() {
            var i = 5
            while (i >= 0) {
                var msg = Message()
                msg.what = MSG
                //把倒计时传过去
                msg.arg1 = i
                //倒计时
                //发送
                handler.sendMessage(msg)
                i--
                try {
                    // 每1000毫秒更新一次位置
                    sleep(1000)
                    //播放进度
                } catch (e: Exception) {
                    // e.printStackTrace()
                    break
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        //开启倒计时线程
        if (thread == null) {
            thread = timeThread()
            thread?.start()
            /* Log.d("Thread", "startThread()....")*/
        }
        start_tiaoguo_bt.setOnClickListener {
            if (thread != null) {
                thread?.interrupt()
                thread = null
            }
            //销毁欢迎界面
            finish()
            //去登录界面
            val intent = Intent(this, DengluActivity::class.java)
            startActivity(intent)
        }
    }
}