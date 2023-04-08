package com.example.ccccccc.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ccccccc.PengrenActivity
import com.example.ccccccc.R
import com.example.ccccccc.ui.YangshengActivity
import com.example.ccccccc.ui.home.MyLoader
import com.example.ccccccc.ui.kepu.KepuActivity
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.banner

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrayImageUrl = arrayListOf<String>(
            "https://cdn.pixabay.com/photo/2018/07/09/09/34/pizza-3525673__340.jpg",
            "https://cdn.pixabay.com/photo/2017/08/07/11/11/sea-cucumber-2602720__340.jpg",
            "https://cdn.pixabay.com/photo/2018/01/01/01/56/yoga-3053488__340.jpg"
        )
        val arrayTitle = arrayListOf<String>("抓住她的胃吧~", "养生知道", "这些你都知道吗")

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



        pengren.setOnClickListener {
            val intent=Intent(activity,PengrenActivity::class.java)
            startActivity(intent)
        }
        yangsheng.setOnClickListener {
            val intent=Intent(activity,YangshengActivity::class.java)
            startActivity(intent)
        }
        kepu.setOnClickListener {
            val intent=Intent(activity,KepuActivity::class.java)
            startActivity(intent)
        }

    }
class MyLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        Glide.with(context).load(path as String).into(imageView)
    }
}}