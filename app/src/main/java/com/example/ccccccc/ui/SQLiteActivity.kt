package com.example.ccccccc.ui

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_s_q_lite.*
import ui.fragment.MyDatabaseHelper


class SQLiteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_q_lite)
        val dbHelper = MyDatabaseHelper(this, "APPdata.db", 3)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values1 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "apple")                //水果名苹果
                put("calories", 53.0)                    //热量
                put("protein",0.4)                       //蛋白质含量
                put("carbohydrate", 13.7)                //碳水化合物
                put("dietary",1.7)                       //膳食纤维含量
                put("na", 1.3)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values1) // 插入第一条数据
            val values2 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "banana")       //水果名香蕉
                put("calories", 93.0)           //热量
                put("protein",1.4)                       //蛋白质含量
                put("carbohydrate", 22.0)                //碳水化合物
                put("dietary",1.2)                       //膳食纤维含量
                put("na", 0.0)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values2) // 插入第一条数据
            val values3 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "tangerine")           //水果名橘子
                put("calories", 44.0)                   //热量
                put("protein",0.8)                       //蛋白质含量
                put("carbohydrate", 10.2)                //碳水化合物
                put("dietary",0.5)                       //膳食纤维含量
                put("na", 0.8)                         //钠含量
                put("fat",0.1)                             //脂肪含量
            }
            db.insert("Fruit", null, values3) // 插入第一条数据
            val values4 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "kiwifruit")//水果名猕猴桃
                put("calories", 62.0)           //热量
                put("protein",0.8)                       //蛋白质含量
                put("carbohydrate", 14.5)                //碳水化合物
                put("dietary",2.6)                       //膳食纤维含量
                put("na", 10.0)                         //钠含量
                put("fat",0.6)                             //脂肪含量
            }
            db.insert("Fruit", null, values4) // 插入第一条数据
            val values5 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "watermelon")//水果名x西瓜
                put("calories", 32.0)           //热量
                put("protein",0.8)                       //蛋白质含量
                put("carbohydrate", 8.0)                //碳水化合物
                put("dietary",0.3)                       //膳食纤维含量
                put("na",3.3 )                         //钠含量
                put("fat",0.1)                             //脂肪含量
            }
            db.insert("Fruit", null, values5) // 插入第一条数据
            val values6 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "grape")//水果名葡萄
                put("calories", 45.0)           //热量
                put("protein",0.4)                       //蛋白质含量
                put("carbohydrate", 10.3)                //碳水化合物
                put("dietary",1.0)                       //膳食纤维含量
                put("na", 1.9)                         //钠含量
                put("fat",0.3)                             //脂肪含量
            }
            db.insert("Fruit", null, values6) // 插入第一条数据
            val values7 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "pineapple")//水果名菠萝
                put("calories", 44.0)           //热量
                put("protein",0.5)                       //蛋白质含量
                put("carbohydrate", 10.8)                //碳水化合物
                put("dietary",1.3)                       //膳食纤维含量
                put("na", 0.8)                         //钠含量
                put("fat",0.1)                             //脂肪含量
            }
            db.insert("Fruit", null, values7) // 插入第一条数据
            val values8 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "strawberry")//水果名草莓
                put("calories", 32.0)           //热量
                put("protein",1.0)                       //蛋白质含量
                put("carbohydrate", 7.1)                //碳水化合物
                put("dietary",1.1)                       //膳食纤维含量
                put("na", 4.2)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values8) // 插入第一条数据
            val values9 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "peach") //水果名桃
                put("calories", 42.0)           //热量
                put("protein",0.6)                       //蛋白质含量
                put("carbohydrate", 10.1)                //碳水化合物
                put("dietary",1.0)                       //膳食纤维含量
                put("na", 1.7)                         //钠含量
                put("fat",0.1)                             //脂肪含量
            }
            db.insert("Fruit", null, values9) // 插入第一条数据
            val values10 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "Cherry")//水果名樱桃
                put("calories", 46.0)           //热量
                put("protein",1.1)                       //蛋白质含量
                put("carbohydrate", 10.2)                //碳水化合物
                put("dietary",0.3)                       //膳食纤维含量
                put("na", 8.0)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values10) // 插入第一条数据

            val values12 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "Mango")//水果名芒果
                put("calories", 35.0)           //热量
                put("protein",0.6)                       //蛋白质含量
                put("carbohydrate", 8.3)                //碳水化合物
                put("dietary",1.3)                       //膳食纤维含量
                put("na", 2.8)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values12) // 插入第一条数据
            val values13 = ContentValues().apply {
                put("fruitname", "grapefruit")//水果名柚子
                put("calories", 42.0)           //热量
                put("protein",0.8)                       //蛋白质含量
                put("carbohydrate", 9.5)                //碳水化合物
                put("dietary",0.4)                       //膳食纤维含量
                put("na", 3.0)                         //钠含量
                put("fat",0.2)                             //脂肪含量
            }
            db.insert("Fruit", null, values13) // 插入第一条数据
            val values14 = ContentValues().apply {
                // 开始组装第一条数据
                put("fruitname", "passionfruit")//水果名百香果
                put("calories", 97.0)           //热量
                put("protein",2.2)                       //蛋白质含量
                put("carbohydrate",23.4)                //碳水化合物
                put("dietary",10.4)                       //膳食纤维含量
                put("na", 28.0)                         //钠含量
                put("fat",0.7)                             //脂肪含量
            }
            db.insert("Fruit", null, values14) // 插入第一条数据
                val values15 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "mifan")//水果名百香果
                    put("calories", 116.0)           //热量
                    put("protein", 2.6)                       //蛋白质含量
                    put("carbohydrate", 25.9)                //碳水化合物
                    put("dietary", 0.3)                       //膳食纤维含量
                    put("na", 2.5)                         //钠含量
                    put("fat", 0.3)                             //脂肪含量
                }
                db.insert("Zhushi", null, values15) // 插入第一条数据
                val values16 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "miantiao")//水果名百香果
                    put("calories", 107.0)           //热量
                    put("protein", 3.9)                       //蛋白质含量
                    put("carbohydrate", 22.8)                //碳水化合物
                    put("dietary", 0.0)                       //膳食纤维含量
                    put("na", 26.9)                         //钠含量
                    put("fat", 0.4)                             //脂肪含量
                }
                db.insert("Zhushi", null, values16) // 插入第一条数据
                val values17 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "mantou")//水果名百香果
                    put("calories", 116.0)           //热量
                    put("protein", 2.6)                       //蛋白质含量
                    put("carbohydrate", 25.9)                //碳水化合物
                    put("dietary", 0.3)                       //膳食纤维含量
                    put("na", 2.5)                         //钠含量
                    put("fat", 0.3)                             //脂肪含量
                }
                db.insert("Zhushi", null, values17) // 插入第一条数据

                val values18 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "mantou")//水果名百香果
                    put("calories", 223.0)           //热量
                    put("protein", 7.0)                       //蛋白质含量
                    put("carbohydrate", 47.9)                //碳水化合物
                    put("dietary", 1.3)                       //膳食纤维含量
                    put("na", 165.1)                         //钠含量
                    put("fat", 1.1)                             //脂肪含量
                }
                db.insert("Zhushi", null, values18) // 插入第一条数据

                val values19 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "huajuan")//水果名百香果
                    put("calories", 230.0)           //热量
                    put("protein", 6.0)                       //蛋白质含量
                    put("carbohydrate", 47.9)                //碳水化合物
                    put("dietary", 1.3)                       //膳食纤维含量
                    put("na", 165.1)                         //钠含量
                    put("fat", 1.1)                             //脂肪含量
                }
                db.insert("Zhushi", null, values19) // 插入第一条数据
                val values20 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "mifan")//水果名百香果
                    put("calories", 175.0)           //热量
                    put("protein", 4.5)                       //蛋白质含量
                    put("carbohydrate", 39.1)                //碳水化合物
                    put("dietary", 1.3)                       //膳食纤维含量
                    put("na", 165.1)                         //钠含量
                    put("fat", 0.4)                             //脂肪含量
                }
                db.insert("Shucai", null, values20) // 插入第一条数据
                val values21 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "baicai")        //水果名百香果
                    put("calories", 20.0)           //热量
                    put("protein", 1.6)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 0.9)                       //膳食纤维含量
                    put("na", 68.9)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values21) // 插入第一条数据
                val values22 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "qincai")//水果名百香果
                    put("calories", 13.0)           //热量
                    put("protein", 1.4)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 0.9)                       //膳食纤维含量
                    put("na", 40.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values22) // 插入第一条数据
                val values23 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "bingcai")//水果名百香果
                    put("calories", 12.0)           //热量
                    put("protein", 1.5)                       //蛋白质含量
                    put("carbohydrate", 1.7)                //碳水化合物
                    put("dietary", 0.9)                       //膳食纤维含量
                    put("na", 40.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values23) // 插入第一条数据
                val values24 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "qincai")//水果名百香果
                    put("calories", 28.0)           //热量
                    put("protein", 2.6)                       //蛋白质含量
                    put("carbohydrate", 4.4)                //碳水化合物
                    put("dietary", 1.9)                       //膳食纤维含量
                    put("na", 85.2)                         //钠含量
                    put("fat", 0.3)                             //脂肪含量
                }
                db.insert("Shucai", null, values24) // 插入第一条数据
                val values25 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "dadou")//水果名百香果
                    put("calories", 369.3)           //热量
                    put("protein", 31.5)                       //蛋白质含量
                    put("carbohydrate", 22.1)                //碳水化合物
                    put("dietary", 0.0)                       //膳食纤维含量
                    put("na", 0.0)                         //钠含量
                    put("fat", 17.6)                             //脂肪含量
                }
                db.insert("Shucai", null, values25) // 插入第一条数据
                val values26 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "doujiao")//水果名百香果
                    put("calories", 34.0)           //热量
                    put("protein", 1.4)                       //蛋白质含量
                    put("carbohydrate", 6.7)                //碳水化合物
                    put("dietary", 2.1)                       //膳食纤维含量
                    put("na", 3.4)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values26) // 插入第一条数据
                val values27 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "fanqie")//水果名百香果
                    put("calories", 15.0)           //热量
                    put("protein", 0.9)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 1.0)                       //膳食纤维含量
                    put("na", 40.1)                         //钠含量
                    put("fat", 9.7)                             //脂肪含量
                }
                db.insert("Shucai", null, values27) // 插入第一条数据
                val values28 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "fuzhu")//水果名百香果
                    put("calories", 161.7)           //热量
                    put("protein", 18.1)                       //蛋白质含量
                    put("carbohydrate", 2.7)                //碳水化合物
                    put("dietary", 0.0)                       //膳食纤维含量
                    put("na", 9.0)                         //钠含量
                    put("fat", 9.1)                             //脂肪含量
                }
                db.insert("Shucai", null, values28) // 插入第一条数据
                val values29 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "huanggua")//水果名百香果
                    put("calories", 16.0)           //热量
                    put("protein", 1.4)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 0.9)                       //膳食纤维含量
                    put("na", 40.1)                         //钠含量
                    put("fat", 4.9)                             //脂肪含量
                }
                db.insert("Shucai", null, values29) // 插入第一条数据

                val values30 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "jiaogua")//水果名百香果
                    put("calories", 19.0)           //热量
                    put("protein", 0.8)                       //蛋白质含量
                    put("carbohydrate", 3.2)                //碳水化合物
                    put("dietary", 0.6)                       //膳食纤维含量
                    put("na", 5.0)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values30) // 插入第一条数据
                val values31 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "juanxincai")//水果名百香果
                    put("calories", 17.0)           //热量
                    put("protein", 0.9)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 2.5)                       //膳食纤维含量
                    put("na", 42.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values31) // 插入第一条数据
                val values32 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "kuju")//水果名百香果
                    put("calories", 17.0)           //热量
                    put("protein", 1.3)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 3.1)                       //膳食纤维含量
                    put("na", 22.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values32) // 插入第一条数据
                val values33 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "huluobo")//水果名百香果
                    put("calories", 32.0)           //热量
                    put("protein", 1.0)                       //蛋白质含量
                    put("carbohydrate", 8.1)                //碳水化合物
                    put("dietary", 2.5)                       //膳食纤维含量
                    put("na", 127.7)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values33) // 插入第一条数据
                val values34 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "juanxincai")//水果名百香果
                    put("calories", 17.0)           //热量
                    put("protein", 0.9)                       //蛋白质含量
                    put("carbohydrate", 3.4)                //碳水化合物
                    put("dietary", 2.5)                       //膳食纤维含量
                    put("na", 42.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values34) // 插入第一条数据
                val values35 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "mogu")//水果名百香果
                    put("calories", 24.0)           //热量
                    put("protein", 2.7)                       //蛋白质含量
                    put("carbohydrate", 4.1)                //碳水化合物
                    put("dietary", 2.1)                       //膳食纤维含量
                    put("na", 8.3)                         //钠含量
                    put("fat", 0.1)                             //脂肪含量
                }
                db.insert("Shucai", null, values35) // 插入第一条数据
                val values36 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "muermo")//水果名百香果
                    put("calories", 46.0)           //热量
                    put("protein", 2.43)                       //蛋白质含量
                    put("carbohydrate", 5.2)                //碳水化合物
                    put("dietary", 1.2)                       //膳食纤维含量
                    put("na", 223.0)                         //钠含量
                    put("fat", 3.0)                             //脂肪含量
                }
                db.insert("Shucai", null, values36) // 插入第一条数据
                val values37 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "nangua")//水果名百香果
                    put("calories", 23.0)           //热量
                    put("protein", 0.7)                       //蛋白质含量
                    put("carbohydrate", 5.3)                //碳水化合物
                    put("dietary", 0.8)                       //膳食纤维含量
                    put("na", 0.8)                         //钠含量
                    put("fat", 0.1)                             //脂肪含量
                }
                db.insert("Shucai", null, values37) // 插入第一条数据
                val values39 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "qiukiu")//水果名百香果
                    put("calories", 25.0)           //热量
                    put("protein", 1.8)                       //蛋白质含量
                    put("carbohydrate", 6.2)                //碳水化合物
                    put("dietary", 1.8)                       //膳食纤维含量
                    put("na", 42.1)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values39) // 插入第一条数据
                val values40 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "qiezi")//水果名百香果
                    put("calories", 23.0)           //热量
                    put("protein", 1.1)                       //蛋白质含量
                    put("carbohydrate", 4.9)                //碳水化合物
                    put("dietary", 2.5)                       //膳食纤维含量
                    put("na", 5.4)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values40) // 插入第一条数据
                val values41 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "tudou")//水果名百香果
                    put("calories", 81.0)           //热量
                    put("protein", 2.6)                       //蛋白质含量
                    put("carbohydrate", 17.8)                //碳水化合物
                    put("dietary", 1.1)                       //膳食纤维含量
                    put("na", 5.9)                         //钠含量
                    put("fat", 0.2)                             //脂肪含量
                }
                db.insert("Shucai", null, values41) // 插入第一条数据
                val values43 = ContentValues().apply {
                    // 开始组装第一条数据
                    put("name", "zicai")//水果名百香果
                    put("calories", 250.0)           //热量
                    put("protein", 0.9)                       //蛋白质含量
                    put("carbohydrate", 44.1)                //碳水化合物
                    put("dietary", 21.6)                       //膳食纤维含量
                    put("na", 710.5)                         //钠含量
                    put("fat", 1.1)                             //脂肪含量
                }
                db.insert("Shucai", null, values43) // 插入第一条数据
            }
            queryData.setOnClickListener {
                val pwdTitle: String = "apple"
                var result = arrayOf<String>()
                val db = dbHelper.writableDatabase
                // 查询Book表中所有的数据
                var cursor: Cursor = db.query(
                    "Fruit",
                    arrayOf("fruitname,calories,protein,carbohydrate,dietary,na,fat"),
                    "fruitname=?",
                    arrayOf<String>(pwdTitle),
                    null,
                    null,
                    null,
                    null
                )
                cursor.moveToFirst()
                // 遍历Cursor对象，取出数据并打印

                val Relang = cursor.getFloat(cursor.getColumnIndex("calories"))
               Log.d("MainActivity", "$Relang")



            }

        }


}




