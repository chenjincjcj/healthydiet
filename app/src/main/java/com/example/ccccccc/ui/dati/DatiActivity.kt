package com.example.ccccccc.ui.dati

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_dati.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class DatiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dati)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val appService = retrofit.create(AppService::class.java)
        appService.getAppData().enqueue(object : retrofit2.Callback<List<App>> {
            override fun onResponse(
                call: Call<List<App>>,
                response: retrofit2.Response<List<App>>
            ) {
                val list = response.body()
                if (list != null) {
                    for (app in list) {
                        dati_title.text=app.id.toString()
                        B.text=app.optionB.toString()
                        A.text=app.optionA.toString()
                        val reslt=app.reslt.toString()
                        A.setOnClickListener {
                            if (reslt=="B") {
                                Toast.makeText(this@DatiActivity,"答案是$reslt",Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(this@DatiActivity,"恭喜你答对了",Toast.LENGTH_SHORT).show()
                            }
                        }
                        B.setOnClickListener {
                            if (reslt=="B") {
                                Toast.makeText(this@DatiActivity,"恭喜你答对了",Toast.LENGTH_SHORT).show()
                            }else{

                                Toast.makeText(this@DatiActivity,"答案是$reslt",Toast.LENGTH_SHORT).show()
                            }
                        }
                        Log.d("MainActivity", "id is ${app.id}")
                        Log.d("MainActivity", "name is ${app.optionA}")
                        Log.d("MainActivity", "version is ${app.optionB}")
                    }
                }
            }


            override fun onFailure(call: Call<List<App>>, t: Throwable) {
                t.printStackTrace()
            }
        })


    }
}
class App(val id: String, val optionA: String, val optionB: String,val reslt:String)
interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>
}
