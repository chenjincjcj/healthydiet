package com.example.ccccccc.ui.jinri

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.core.view.drawToBitmap
import com.bumptech.glide.Glide
import com.example.ccccccc.R
import com.example.ccccccc.ui.dati.LianjieActivity
import com.example.ccccccc.xiaxian.Xuanze
import com.example.ccccccc.xiaxian.XuanzeService
import kotlinx.android.synthetic.main.activity_bbbb.*
import kotlinx.android.synthetic.main.activity_jinri.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.concurrent.thread

class JinriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jinri)
        swipeRefresh2.setColorSchemeResources(R.color.purple_200)
        swipeRefresh2.setOnRefreshListener {
            refreshFruits()
        }
    }
    fun refreshFruits() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val JinriService = retrofit.create(JinriService::class.java)
                JinriService.getJinri().enqueue(object : Callback<List<Jinri>> {
                    override fun onResponse(
                        call: Call<List<Jinri>>,
                        response: Response<List<Jinri>>
                    ) {
                        val list = response.body()
                        if (list != null) {
                            for (jinri in list) {
                                val image:String=jinri.id
                                Glide.with(this@JinriActivity).load("$image").into(jinri_image)
//                                val bitmap=stringToBitmap(string =jinri.id )
//                                jinri_image.setImageBitmap(bitmap)
                                name.text = jinri.optionA
                                msage.text = jinri.optionB
                                Log.d("MainActivity", "id is ${jinri.id}")
                                Log.d("MainActivity", "name is ${jinri.optionA}")
                                Log.d("MainActivity", "version is ${jinri.optionB}")
                            }
                        }
                    }


                    override fun onFailure(call: Call<List<Jinri>>, t: Throwable) {
                        t.printStackTrace()

                    }

                })
                swipeRefresh2.isRefreshing = false
            }
        }
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
class Jinri(val id: String, val optionA: String, val optionB: String,val reslt:String)
interface JinriService {
    @GET("jinri.json")
    fun getJinri(): Call<List<Jinri>>
}