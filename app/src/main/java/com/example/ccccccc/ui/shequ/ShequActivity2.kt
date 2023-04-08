package com.example.ccccccc.ui.shequ

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_shequ2.*


class
ShequActivity2 : AppCompatActivity() {
    val shequList = ArrayList<Shequ>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shequ2)
        initShequ() // 初始化水果数据
        val layoutManager = LinearLayoutManager(this)
        shequ_recyclerview.layoutManager = layoutManager
        val adapter = ShequAdaper(shequList)
        shequ_recyclerview.adapter = adapter
        fab.setOnClickListener {
            val intent=Intent(this, ShequActivity::class.java)
            startActivity(intent)
        }
        tab_add.setOnClickListener {
            val bitmap2:Bitmap=BitmapFactory.decodeResource(this.resources,R.drawable.jianshen)
    val  shequ=Shequ("李华","你不会不知道大厦就看见哈的卡号是的接口",bitmap2)
         adapter.addCourse(shequ)
        }

    }


    fun initShequ() {
        val intent=intent
        val nane=intent.getStringExtra("name").toString()
        val masage=intent.getStringExtra("massage").toString()
        Log.d("aaa",masage)

        val bitmap1: String? = intent.getStringExtra("bitmap")
        val bitmap=stringToBitmap(bitmap1)
        val bitmap2:Bitmap=BitmapFactory.decodeResource(this.resources,R.drawable.jianshen)
            shequList.add(Shequ(nane, masage, bitmap))
        shequList.add(Shequ("小虎", "如何风花雪月", bitmap2))


    }
    fun stringToBitmap(string: String?): Bitmap? {
        // 将字符串转换成Bitmap类型
        var bitmap: Bitmap? = null
        try {
            val bitmapArray: ByteArray
            bitmapArray = Base64.decode(string, Base64.DEFAULT)
            bitmap = BitmapFactory.decodeByteArray(
                bitmapArray, 0,
                bitmapArray.size
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}


