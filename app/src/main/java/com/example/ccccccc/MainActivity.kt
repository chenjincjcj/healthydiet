package com.example.ccccccc

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.Cursor
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.ccccccc.HTTP.HiOkhttp
import com.example.ccccccc.ui.Massag
import com.example.ccccccc.ui.jianshen.JianshennActivity
import com.example.ccccccc.ui.shequ.ShequActivity2
import com.example.ccccccc.ui.start.HiRetrofit
import com.example.ccccccc.xiaxian.BaseActivity
import com.example.ccccccc.xiaxian.TizhongActivity
import com.example.ccccccc.xiaxian.WeiActivity
import com.example.ccccccc.xiaxian.bbbbActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_jilu.*
import ui.fragment.MyDatabaseHelper
import kotlin.concurrent.thread

class MainActivity : BaseActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal", NotificationManager.
            IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.user_img)
        }
        navView.setCheckedItem(R.id.navCall)
        navView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navCall -> {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:10086")
                        startActivity(intent)
                    }
                    R.id.navLocation -> {
                        val intent1 = Intent(Intent.ACTION_VIEW)
                        intent1.data = Uri.parse("geo:38.899533,-77.036476")
                        startActivity(intent1)
                    }
                    R.id.navMail -> {
                        val intent1 = Intent(Intent.ACTION_SENDTO)
                        intent1.data = Uri.parse("mailto:xxxx@gmail.com")
                        startActivity(intent1)
                    }
                }
                return true
            }
        }

        )


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.delete -> Toast.makeText(
                this, "签到成功",
                Toast.LENGTH_SHORT
            ).show()
            R.id.settings -> {
                val intent = Intent(this, Massag::class.java)
                startActivity(intent)
            }

        }
        return true
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
          thread {
              tongzhi()
              Thread.sleep(2000)
              tongzhi1()
              Thread.sleep(2000)
              tongzhi2()

          }
        }
    }
    fun tongzhi(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intent = Intent(this, WeiActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("小知识更新啦")
                .setContentText("快来了解你的胃吧")
                .setSmallIcon(R.drawable.user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,
                    R.drawable.nav_icon))
                .setContentIntent(pi)
                .build()
            manager.notify(1, notification)
        }

    }
    fun tongzhi1(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intent = Intent(this, TizhongActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("快来看看你的体重报告吧")
                .setContentText("给自己定一个小目标吧")
                .setSmallIcon(R.drawable.user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,
                    R.drawable.nav_icon))
                .setContentIntent(pi)
                .build()
            manager.notify(2, notification)

        }

}
    fun tongzhi2(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intent = Intent(this, JianshennActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "normal")
                .setContentTitle("运动")
                .setContentText("燃烧我的卡路里")
                .setSmallIcon(R.drawable.user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,
                    R.drawable.nav_icon))
                .setContentIntent(pi)
                .build()
            manager.notify(3, notification)
        }

    }
}



