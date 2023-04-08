package com.example.ccccccc.ui.jilu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.icu.text.CaseMap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ccccccc.R
import com.example.ccccccc.ui.home.MyLoader
import com.example.ccccccc.ui.jianshen.JianshennActivity
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_jilu.*
import kotlinx.android.synthetic.main.fragment_jilu.banner
import kotlinx.android.synthetic.main.fragment_jilu.name
import kotlinx.android.synthetic.main.fragment_notifications.*
import ui.fragment.MyDatabaseHelper


class JiluFragment:Fragment() {
    private lateinit var jiluFragmentViewModel: JiluViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jiluFragmentViewModel =
            ViewModelProvider(this).get(JiluViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_jilu, container, false)
        jiluFragmentViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        return root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayImageUrl = arrayListOf<String>(
            "https://cdn.pixabay.com/photo/2014/09/29/06/21/fruits-465832__340.jpg",
            "https://cdn.pixabay.com/photo/2018/07/11/22/18/stomach-3532098__340.jpg",
            "https://cdn.pixabay.com/photo/2010/12/13/10/06/apple-2311__340.jpg"
        )
        val arrayTitle = arrayListOf<String>("计算出你一天的热量是多少吧", "科学饮食", "你不知道的食物热量")

        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(MyLoader())
        //设置图片网址或地址的集合
        banner.setImages(arrayImageUrl)
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default)
        //设置轮播图的标题集合
        banner.setBannerTitles(arrayTitle)
        //设置轮播间隔时间
        banner.setDelayTime(3000)
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true)
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
        //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。

        banner.setOnBannerListener {
            Log.d("=*=", "第几张" + it.dec())

        }

        //必须最后调用的方法，启动轮播图。
        banner.start()


        fun initBanner() {

        }

        val dbHelper = context?.let { MyDatabaseHelper(it, "APPdata.db", 3) }
        zao_fruit_que.setOnClickListener {
            val f = ZHUAN_Fruit(shu_fruit = zao_fruit.text.toString())
            val F: Float = fruit(pwdTitle = f)
            shengcheng_a.text = (F / 100).toString()
        }

        zao_shucai_que.setOnClickListener {
            val s = ZHUAN_Shucai(shu_shucai = zao_shucai.text.toString())
            val S: Float = shucai(pwdTitle2 = s.toString())
            shengcheng_a.text = (S / 100).toString()
        }
        zao_zhushi_que.setOnClickListener {
            val z = ZHUAN_Zhushi(shu_zhushi = zao_zhushi.text.toString())
            val Z: Float = zhushi(pwdTitle3 = z)
            shengcheng_a.text = (Z / 100).toString()
        }
        shengchneg.setOnClickListener {
            val f = ZHUAN_Fruit(shu_fruit = zao_fruit.text.toString())
            val F: Float = fruit(pwdTitle = f.toString())
            val z = ZHUAN_Zhushi(shu_zhushi = zao_zhushi.text.toString())
            val Z: Float = zhushi(pwdTitle3 = z)
            val s = ZHUAN_Shucai(shu_shucai = zao_shucai.text.toString())
            val S: Float = shucai(pwdTitle2 = s.toString())
            shengcheng_a.text =
                ((F / 100).toFloat() + (S / 100).toFloat() + (Z / 100).toFloat()).toString()
        }

        shucaiquerya.setOnClickListener {
            val s = ZHUAN_Shucai(shu_shucai = Shucai.text.toString())
            val pwdTitle: String = s.toString()
            var result = arrayOf<String>()
            val db = dbHelper!!.writableDatabase
            // 查询Book表中所有的数据
            var cursor1: Cursor = db.query(
                "Shucai",
                arrayOf("name,calories,protein,carbohydrate,dietary,na,fat"),
                "name=?",
                arrayOf<String>(pwdTitle),
                null,
                null,
                null,
                null
            )
            cursor1.moveToFirst()
            // 遍历Cursor对象，取出数据并打印
            val Name = cursor1.getString(cursor1.getColumnIndex("name"))
            val Relang = cursor1.getFloat(cursor1.getColumnIndex("calories"))
            val Danbai = cursor1.getString(cursor1.getColumnIndex("protein"))
            val Tanshui = cursor1.getString(cursor1.getColumnIndex("carbohydrate"))
            val Shanshi = cursor1.getString(cursor1.getColumnIndex("dietary"))
            val Na = cursor1.getString(cursor1.getColumnIndex("na"))
            val Zhifang = cursor1.getString(cursor1.getColumnIndex("fat"))
            Log.d("NAME", Name)
            name.text = Shucai.text.toString()
            reliang.text = Relang.toString()
            danbaizhi.text = Danbai.toString()
            tanshui.text = Tanshui.toString()
            shanshi.text = Shanshi.toString()
            na.text = Na.toString()
            zhifang.text = Zhifang.toString()

        }
        zhishiquery.setOnClickListener {
            val z = ZHUAN_Zhushi(shu_zhushi = Zhushi.text.toString())
            val pwdTitle: String = z.toString()
            var result = arrayOf<String>()
            val db = dbHelper!!.writableDatabase
            // 查询Book表中所有的数据
            var cursor: Cursor = db.query(
                "Zhushi",
                arrayOf("name,calories,protein,carbohydrate,dietary,na,fat"),
                "name=?",
                arrayOf<String>(pwdTitle),
                null,
                null,
                null,
                null
            )
            cursor.moveToFirst()
            // 遍历Cursor对象，取出数据并打印
            val Name = cursor.getString(cursor.getColumnIndex("name"))
            val Relang = cursor.getFloat(cursor.getColumnIndex("calories"))
            val Danbai = cursor.getString(cursor.getColumnIndex("protein"))
            val Tanshui = cursor.getString(cursor.getColumnIndex("carbohydrate"))
            val Shanshi = cursor.getString(cursor.getColumnIndex("dietary"))
            val Na = cursor.getString(cursor.getColumnIndex("na"))
            val Zhifang = cursor.getString(cursor.getColumnIndex("fat"))
            name.text = Shucai.text.toString()
            reliang.text = Relang.toString()
            danbaizhi.text = Danbai.toString()
            tanshui.text = Tanshui.toString()
            shanshi.text = Shanshi.toString()
            na.text = Na.toString()
            zhifang.text = Zhifang.toString()

        }
        jianshen.setOnClickListener {
            val intent = Intent(activity, JianshennActivity::class.java)
            startActivity(intent)
        }

        fruitquery.setOnClickListener {
            val f = ZHUAN_Fruit(shu_fruit = Fruit.text.toString())
            val pwdTitle: String = f.toString()
            var result = arrayOf<String>()
            val db = dbHelper!!.writableDatabase
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
            val Name = cursor.getString(cursor.getColumnIndex("fruitname"))
            val Relang = cursor.getFloat(cursor.getColumnIndex("calories"))
            val Danbai = cursor.getString(cursor.getColumnIndex("protein"))
            val Tanshui = cursor.getString(cursor.getColumnIndex("carbohydrate"))
            val Shanshi = cursor.getString(cursor.getColumnIndex("dietary"))
            val Na = cursor.getString(cursor.getColumnIndex("na"))
            val Zhifang = cursor.getString(cursor.getColumnIndex("fat"))
            name.text = Fruit.text.toString()
            reliang.text = Relang.toString()
            danbaizhi.text = Danbai.toString()
            tanshui.text = Tanshui.toString()
            shanshi.text = Shanshi.toString()
            na.text = Na.toString()
            zhifang.text = Zhifang.toString()

        }
        val data: SharedPreferences = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)!!
        val dname = data.getString("name", "")
        val sp: SharedPreferences =
            activity?.getSharedPreferences("${dname.toString()}", Context.MODE_PRIVATE)!!
        val bim = sp.getFloat("BIM", -1f)
        BIM_jilu.text = bim.toString()
        val Aa: Float = sheru(shengao = sp.getFloat("shengao", -1f))
        Sheru.text = Aa.toString()
    }

    fun fruit(pwdTitle: String): Float {
        val dbHelper = context?.let { MyDatabaseHelper(it, "APPdata.db", 3) }
        var fruit_re: Float
        var result = arrayOf<String>()
        val db = dbHelper!!.writableDatabase
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
        ).also {
            it.moveToFirst()
        }
        // 遍历Cursor对象，取出数据并打印

        val Relang: Float = cursor.getFloat(cursor.getColumnIndex("calories"))
        val keshu = zao_fruit_keshu.text.toString()
        fruit_re = keshu.toFloat() * Relang
        return fruit_re
    }

    fun zhushi(pwdTitle3: String): Float {
        val dbHelper = context?.let { MyDatabaseHelper(it, "APPdata.db", 3) }
        var zhushi_re: Float
        var result = arrayOf<String>()
        val db = dbHelper!!.writableDatabase
        // 查询Book表中所有的数据
        var cursor: Cursor = db.query(
            "Zhushi",
            arrayOf("name,calories,protein,carbohydrate,dietary,na,fat"),
            "name=?",
            arrayOf<String>(pwdTitle3),
            null,
            null,
            null,
            null
        ).also {
            it.moveToFirst()
        }
        // 遍历Cursor对象，取出数据并打印

        val Relang: Float = cursor.getFloat(cursor.getColumnIndex("calories"))
        val keshu = zao_zhushi_keshu.text.toString()
        zhushi_re = keshu.toFloat() * Relang
        return zhushi_re

    }

    fun shucai(pwdTitle2: String): Float {
        val dbHelper = context?.let { MyDatabaseHelper(it, "APPdata.db", 3) }
        var shucai_re: Float
        var result = arrayOf<String>()
        val db = dbHelper!!.writableDatabase
        // 查询Book表中所有的数据
        var cursor: Cursor = db.query(
            "Shucai",
            arrayOf("name,calories,protein,carbohydrate,dietary,na,fat"),
            "name=?",
            arrayOf<String>(pwdTitle2),
            null,
            null,
            null,
            null
        ).also {
            it.moveToFirst()
        }
        // 遍历Cursor对象，取出数据并打印

        val Relang: Float = cursor.getFloat(cursor.getColumnIndex("calories"))
        val keshu = zao_shucai_kehsu.text.toString()
        shucai_re = keshu.toFloat() * Relang
        return shucai_re


    }

    fun sheru(shengao: Float): Float {
        val data: SharedPreferences = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)!!
        val dname = data.getString("name", "")
        val sp: SharedPreferences =
            activity?.getSharedPreferences("${dname.toString()}", Context.MODE_PRIVATE)!!
        val zhiye = sp.getInt("NEI", 0)
        val SHURU: Float
        val Biaozhun = ((shengao - 70.0) * 0.6).toFloat()
        if (zhiye == 1) {
            ZHIYE.text = "内勤工作者"
            SHURU = ((25.0 * Biaozhun - 70.0) + 500).toFloat()
            return SHURU
        } else if (zhiye == 2) {
            ZHIYE.text = "外勤工作者"
            SHURU = ((30.0 * Biaozhun - 70.0) + 500).toFloat()

        } else {
            ZHIYE.text = "劳动工作者"
            SHURU = ((35.0 * Biaozhun - 70.0) + 500).toFloat()
        }


        return SHURU
    }

    fun ZHUAN_Fruit(shu_fruit:String): String {
        var chu_fruit=""
        when(shu_fruit){

            "苹果"->chu_fruit="apple"
            "香蕉"->chu_fruit="banana"
            "橘子"->chu_fruit="tangerine"
            "猕猴桃"->chu_fruit="kiwifruit"
            "西瓜"->chu_fruit="watermelon"
            "葡萄"->chu_fruit="grape"
            "菠萝"->chu_fruit="pineapple"
            "草莓"->chu_fruit="strawberry"
            "桃"->chu_fruit="peach"
            "樱桃"->chu_fruit="Cherry"
            "芒果"->chu_fruit="Mango"
            "柚子"->chu_fruit="grapefruit"
            "百香果"->chu_fruit="passionfruit"

        }
        return chu_fruit

    }
    fun ZHUAN_Zhushi(shu_zhushi:String): String {
        var chu_zhushi=""
        when(shu_zhushi){

        "米饭"->chu_zhushi="mifan"
        "花卷"->chu_zhushi="huajuan"
        "馒头"->chu_zhushi="mantou"
        "面条"->chu_zhushi="miantiao"
            "粽子"->chu_zhushi="zongzi"
        }
        return chu_zhushi

    }
    fun ZHUAN_Shucai(shu_shucai:String): String {
        var chu_shucai=""
        when(shu_shucai){
            "白菜"->chu_shucai="baicai"
            "芹菜"->chu_shucai="qincai"
            "冰菜"->chu_shucai="bingcai"
            "大豆"->chu_shucai="dadou"
            "豆角"->chu_shucai="doujiao"
            "番茄"->chu_shucai="fanqie"
            "腐竹"->chu_shucai="fuzhu"
            "黄瓜"->chu_shucai="huanggua"
            "角瓜"->chu_shucai="jiaogua"
            "卷心菜"->chu_shucai="juanxincai"
            "蘑菇"->chu_shucai="mogu"
            "木耳蘑"->chu_shucai="muermo"
            "南瓜"->chu_shucai="nangua"
            "秋葵"->chu_shucai="qiukui"
            "茄子"->chu_shucai="qiezi"
            "土豆"->chu_shucai="tudou"
            "紫菜"->chu_shucai="zicai"
        }
       return chu_shucai

    }





}

class MyLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        Glide.with(context).load(path as String).into(imageView)
    }
}




