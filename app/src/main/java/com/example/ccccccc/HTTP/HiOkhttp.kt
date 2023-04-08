package com.example.ccccccc.HTTP

import android.util.Log
import kotlinx.coroutines.Runnable
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

object HiOkhttp {
    private  val BASH_URL="http://123.56.232.18:8080/serverdemo";

        val client = OkHttpClient.Builder()    //builder构造者设计模式
            .connectTimeout(10, TimeUnit.SECONDS) //连接超时时间
            .readTimeout(10, TimeUnit.SECONDS)    //读取超时
            .writeTimeout(10, TimeUnit.SECONDS)  //写超时，也就是请求超时
            .build()

        fun get() {

            Thread(Runnable {
                //构造请求体
                val request: Request = Request.Builder()
                    .url("$BASH_URL/user/query?userId=1604564544545")
                    .build()
                //构造实例化对象
                val call = client.newCall(request)
                //发起同步请求execute
                val response:Response= call.execute()
                val body:String? = response.body?.string()
                Log.d("LOG","get response :${body}")
                println("get response :${body}")

            }).start()
        }
    fun getAsync() {
        //构造请求体
        val request: Request = Request.Builder()
            .url("$BASH_URL/user/query?userId=1604564544545")
            .build()
        //构造实例化对象
        val call = client.newCall(request)
        //发起同步请求execute
        //异步请求enqueue
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("OKHTTP", "get reponse onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body: String? = response.body?.string()
                Log.e("OKHTTP", "get reponse:${body}")
            }

        })
    }
fun post(){
    val body = FormBody.Builder()
        .add("userId","163565654")
        .add("tagId","71")
        .build();
    val request = Request.Builder()
        .url("http://10.0.2.2/get_data.json")
        .post(body)
        .build();
//    val response = client.newCall(request).execute();
//    val body:String? = response.body?.string()
//    Log.d("LOG","get response :${body}")
//    println("get response :${body}")
//    }
    val call = client.newCall(request)
    Thread(Runnable{

      val response  =call.execute()
        Log.e("OKHTTP","POST response:${response.body?.string()}")
    }).start()}



}