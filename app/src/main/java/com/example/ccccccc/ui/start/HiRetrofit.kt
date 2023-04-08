package com.example.ccccccc.ui.start

import okhttp3.FormBody
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

class HiRetrofit {
    val body = FormBody.Builder()
        .add("key1","fsjuoi")
        .add("key","fdhjkl")
        .build();
    val client  = OkHttpClient.Builder()    //builder构造者设计模式
        .connectTimeout(10, TimeUnit.SECONDS) //连接超时时间
        .readTimeout(10, TimeUnit.SECONDS)    //读取超时
        .writeTimeout(10, TimeUnit.SECONDS)  //写超时，也就是请求超时
        .build();
   private var retrofit:Retrofit=Retrofit.Builder()
        .client(client)
        .baseUrl("http://10.0.2.2")
        .addConverterFactory(GsonConverterFactory.create())
       
        .build()
    private fun<T> creat(clazz: Class<T>):T{
    return  retrofit.create(clazz)
}
}
interface ApiService {
    @GET("xuanze.json")
fun querUser(@Query(value = "userId",encoded = true)userId:String):Class<String>
@POST("xuanze.json")
fun getStudy():Class<List<Course>>
}
data class Course(
    val label: String,
    val poster: String,
    val progress: String,
    val title: String
)