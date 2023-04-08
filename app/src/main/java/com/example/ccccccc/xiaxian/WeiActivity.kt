
package com.example.ccccccc.xiaxian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccccccc.Adaper.MsgAdapter
import com.example.ccccccc.R
import com.example.ccccccc.ui.dati.LianjieActivity
import kotlinx.android.synthetic.main.activity_bbbb.*
import kotlinx.android.synthetic.main.activity_wei.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.concurrent.thread

class WeiActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wei)
        webView.settings.javaScriptEnabled=true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://chenjin.host3v.club/05评论列表.html")
        refreshFruits()
        swipeRefresh1.setColorSchemeResources(R.color.purple_200)
        swipeRefresh1.setOnRefreshListener {
            refreshFruits()
        }
        val layoutManager = LinearLayoutManager(this)
        recyclerView_wei.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView_wei.adapter = adapter
        send.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，
//                    刷新RecyclerView中的显示
                    recyclerView_wei.scrollToPosition(msgList.size - 1) // 将RecyclerView
//                    定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

fun refreshFruits(){
    thread {
        Thread.sleep(2000)
        runOnUiThread {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val WeiService = retrofit.create(WeiService::class.java)
    WeiService.getwei().enqueue(object : Callback<List<Wei>> {
        override fun onResponse(
            call: Call<List<Wei>>,
            response: Response<List<Wei>>
        ) {
            val list = response.body()
            if (list != null) {
                for (wei in list) {
                    wei_title.text = wei.id
                    wei_msage.text = wei.optionA
                    liayuan_wei.text = wei.optionB
                    xiangguan_wei.setOnClickListener {
                        val Lianjie = wei.reslt.toString()
                        val intent = Intent(this@WeiActivity, LianjieActivity::class.java)
                        intent.putExtra("lianjie", "$Lianjie")
                        startActivity(intent)
                    }


                    Log.d("MainActivity", "id is ${wei.id}")
                    Log.d("MainActivity", "name is ${wei.optionA}")
                    Log.d("MainActivity", "version is ${wei.optionB}")
                }
            }
        }


        override fun onFailure(call: Call<List<Wei>>, t: Throwable) {
            t.printStackTrace()
        }
    })
            swipeRefresh1.isRefreshing = false
      }
    }
}

}

class Wei(val id: String, val optionA: String, val optionB: String,val reslt:String)
interface WeiService {
    @GET("wei.json")
    fun getwei(): Call<List<Wei>>
}