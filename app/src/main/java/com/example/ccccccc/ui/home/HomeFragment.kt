package com.example.ccccccc.ui.home

import android.content.Context
import android.content.Intent
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
import com.example.ccccccc.ui.dati.DatiActivity
import com.example.ccccccc.FruitActivity
import com.example.ccccccc.R
import com.example.ccccccc.ZhushiActivity
import com.example.ccccccc.xiaxian.bbbbActivity
import kotlinx.android.synthetic.main.fragment_home.*
import com.example.ccccccc.ShucaiActivity
import com.example.ccccccc.ui.jinri.JinriActivity
import com.example.ccccccc.xiaxian.WeiActivity
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader


class  HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayImageUrl = arrayListOf<String>(
            "https://cdn.pixabay.com/photo/2016/09/12/08/22/breakfast-1663295__340.jpg",
            "https://cdn.pixabay.com/photo/2015/01/30/18/13/diet-617756__340.jpg",
            "https://cdn.pixabay.com/photo/2015/07/31/15/00/watermelon-869207__340.jpg"
        )
        val arrayTitle = arrayListOf<String>("今日食谱推荐", "今日小知识", "每日一小菜系")

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
            val intent=Intent(activity, JinriActivity::class.java)
            startActivity(intent)
        }
        banner.setOnClickListener {

        }
        //必须最后调用的方法，启动轮播图。
        banner.start()


        fun initBanner() {

        }
        item_fruit.setOnClickListener {
            val intent = Intent(activity, FruitActivity::class.java)
            startActivity(intent)
        }
        item_shucai.setOnClickListener {
            val intent = Intent(activity, ShucaiActivity::class.java)
            startActivity(intent)
        }
        item_zhushi.setOnClickListener {
            val intent = Intent(activity, ZhushiActivity::class.java)
            startActivity(intent)
        }
        dati.setOnClickListener {
            val intent = Intent(activity, DatiActivity::class.java)
            startActivity(intent)
        }
        xuanze.setOnClickListener {
            val intent = Intent(activity, bbbbActivity::class.java)
            startActivity(intent)
        }
        wei.setOnClickListener {
            val intent = Intent(activity, WeiActivity::class.java)
            startActivity(intent)
        }

    }
}

class MyLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        Glide.with(context).load(path as String).into(imageView)
    }
}


