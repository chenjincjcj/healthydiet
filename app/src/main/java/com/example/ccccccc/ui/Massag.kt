package com.example.ccccccc.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ccccccc.R
import com.example.ccccccc.xiaxian.BaseActivity
import kotlinx.android.synthetic.main.activity_massag.*
import kotlinx.android.synthetic.main.fragment_notifications.*

class Massag : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_massag)
       button_xiaxian.setOnClickListener {
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
        button_OK.setOnClickListener {
            val shengao1=edit_shengao1.text.toString()
            val tizhong1=edit_tizhong1.text.toString()
            val tizhong2=edit_tizhong2.text.toString()
            val time=edit_time.text.toString()
            val age1=edit_age1.text.toString()
            val phone1=edit_phone1.text.toString()
            val password1=edit_possword1.text.toString()
            val data: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)!!
            val dname=data.getString("name","")
            val editor = getSharedPreferences("$dname", Context.MODE_PRIVATE).edit()
            val BIM:Float=(tizhong1.toFloat()/(shengao1.toFloat()*shengao1.toFloat()))*10000
            val BIM1:Float=(tizhong2.toFloat()/(shengao1.toFloat()*shengao1.toFloat()))*10000

            editor.putString("phone", "$phone1")
            editor.putString("password", "$password1")
            editor.putString("time", "$time")
            editor.putFloat("tizhong",tizhong1.toFloat())
            editor.putFloat("tizhong2",tizhong2.toFloat())
            editor.putFloat("shengao", shengao1.toFloat())
            editor.putString("age", "$age1")
            editor.putFloat("BIM",BIM)
            editor.putFloat("BIM1",BIM1)
            editor.apply()
            editor.commit()
        }

    }
}