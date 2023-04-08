package com.example.ccccccc.xiaxian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccccccc.Adaper.MsgAdapter
import com.example.ccccccc.R
import com.example.ccccccc.ui.dati.LianjieActivity
import kotlinx.android.synthetic.main.activity_bbbb.*
import kotlinx.android.synthetic.main.activity_dati.*
import kotlinx.android.synthetic.main.activity_wei.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.concurrent.thread

class bbbbActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbbb)
        refreshFruits()
        swipeRefresh.setColorSchemeResources(R.color.purple_200)
        swipeRefresh.setOnRefreshListener {
            refreshFruits()
        }
        initMsg()

        val layoutManager = LinearLayoutManager(this)
        recyclerView_xuanze.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView_xuanze.adapter = adapter
        send1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            send1 -> {
                val content = inputText1.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，
//                    刷新RecyclerView中的显示
                    recyclerView_xuanze.scrollToPosition(msgList.size - 1) // 将RecyclerView
//                    定位到最后一行
                    inputText1.setText("") // 清空输入框中的内容
                }
            }
        }
    }
    private fun initMsg() {
        val msg1 = Msg("确实不错", Msg.TYPE_SENT)
        msgList.add(msg1)
        val msg2 = Msg("小知识很实用啊", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("什么时候更新啊 ", Msg.TYPE_SENT)
        msgList.add(msg3)
    }
    fun refreshFruits() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val xuanzeService = retrofit.create(XuanzeService::class.java)
                xuanzeService.getXuanze().enqueue(object : retrofit2.Callback<List<Xuanze>> {
                    override fun onResponse(
                        call: Call<List<Xuanze>>,
                        response: retrofit2.Response<List<Xuanze>>
                    ) {
                        val list = response.body()
                        if (list != null) {
                            for (xuanze in list) {
                                xuanze_title.text = xuanze.id
                                masage.text = xuanze.optionA
                                laiyuan.text = xuanze.optionB
                                lianjie.setOnClickListener {
                                    val Lianjie = xuanze.reslt.toString()
                                    val intent =
                                        Intent(this@bbbbActivity, LianjieActivity::class.java)
                                    intent.putExtra("lianjie", "$Lianjie")
                                    startActivity(intent)
                                }


                                Log.d("MainActivity", "id is ${xuanze.id}")
                                Log.d("MainActivity", "name is ${xuanze.optionA}")
                                Log.d("MainActivity", "version is ${xuanze.optionB}")
                            }
                        }
                    }


                    override fun onFailure(call: Call<List<Xuanze>>, t: Throwable) {
                        t.printStackTrace()

                    }
                })
                swipeRefresh.isRefreshing = false
            }
        }
    } 
}
class Xuanze(val id: String, val optionA: String, val optionB: String,val reslt:String)
interface XuanzeService {
    @GET("xuanze.json")
    fun getXuanze(): Call<List<Xuanze>>
}