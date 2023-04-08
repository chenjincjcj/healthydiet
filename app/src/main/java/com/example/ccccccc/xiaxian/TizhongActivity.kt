package com.example.ccccccc.xiaxian

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ccccccc.R
import com.example.ccccccc.ui.Massag
import com.example.ccccccc.ui.dati.LianjieActivity
import kotlinx.android.synthetic.main.activity_bbbb.*
import kotlinx.android.synthetic.main.activity_tizhong.*
import kotlinx.android.synthetic.main.fragment_jilu.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TizhongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tizhong)
        tizhong_mubiao.setOnClickListener {
            val intent=Intent(this,Massag::class.java)
            startActivity(intent)
        }
        but_liaojie.setOnClickListener {
            val intent=Intent(this@TizhongActivity, LianjieActivity::class.java)
            intent.putExtra("lianjie", "https://mbd.baidu.com/newspage/data/landingsuper?rs=1547988648&ruk=jdxbRo1J50CG_yKIrIAUhw&isBdboxFrom=1&pageType=1&urlext=%7B%22cuid%22%3A%22YO-ou0ugHilk8HuZ_avm8luqH8_CaviVgi2zu_aV-aKm0qqSB%22%7D&context=%7B%22nid%22%3A%22news_8914040675192412273%22%7D")
            startActivity(intent)
        }
        tizhong_yundong.setOnClickListener {
            val intent=Intent(this@TizhongActivity, LianjieActivity::class.java)
            intent.putExtra("lianjie", "https://m.bohe.cn/news/mip/39864.html")
            startActivity(intent)
        }
        val data: SharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)!!
        val dname=data.getString("name","")
        val sp = getSharedPreferences("$dname", Context.MODE_PRIVATE)
        BIM_MU.text=sp.getFloat("tizhong2",-1f).toString()
        TIME.text=sp.getString("time","").toString()
        tizhong_zuixin.text=sp.getFloat("tizhong",-1f).toString()
        tizhong_BIM.text=sp.getFloat("BIM",-1F).toString()
        val tizhong=sp.getFloat("tizhong2",-1f)
        tizhong_re.text=(tizhong*22).toString()
        tizhong_tanshui.text=((tizhong.toInt())*0.53).toString()
        tizhong_zhifang.text=((tizhong.toInt())*0.30).toString()
        tizhong_danbai.text=((tizhong.toInt())*0.17).toString()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val TizhongService = retrofit.create(TizhongService::class.java)
        TizhongService.getTizhong().enqueue(object : retrofit2.Callback<List<Tizhong>> {
            override fun onResponse(
                call: Call<List<Tizhong>>,
                response: retrofit2.Response<List<Tizhong>>
            ) {
                val list = response.body()
                if (list != null) {
                    for (tizhong in list) {
                        tizhong_texte1.text=tizhong.id
                        tizhong_texte2.text=tizhong.optionA
                        tizhong_texte3.text=tizhong.optionB
                        tizhong_yundong.setOnClickListener {
                            val Lianjie=tizhong.reslt.toString()
                            val intent=Intent(this@TizhongActivity, LianjieActivity::class.java)
                            intent.putExtra("lianjie", "$Lianjie")
                            startActivity(intent)
                        }


                        Log.d("MainActivity", "id is ${tizhong.id}")
                        Log.d("MainActivity", "name is ${tizhong.optionA}")
                        Log.d("MainActivity", "version is ${tizhong.optionB}")
                    }
                }
            }


            override fun onFailure(call: Call<List<Tizhong>>, t: Throwable) {
                t.printStackTrace()
            }
        })


    }
}
class Tizhong(val id: String, val optionA: String, val optionB: String,val reslt:String)
interface TizhongService {
    @GET("tizhong.json")
    fun getTizhong(): Call<List<Tizhong>>
}
