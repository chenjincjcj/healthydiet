package com.example.bishe

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*
import ui.fragment.HomeFragment
import ui.fragment.NewsFragment
import ui.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tab_group.addOnButtonCheckedListener { group, checkedId, isChecked ->
            //拿到制作了按钮的数量
            val childCount = group.childCount
            //index用于后面对fragment操作
            var index = 0
            for (i in 0 until childCount) {
                val childAt = group.getChildAt(i) as MaterialButton
                //让被选中的按钮改变颜色
                if (childAt.id == checkedId) {
                    index = i
                    childAt.setTextColor(Color.BLUE)
                    childAt.iconTint = ColorStateList.valueOf(Color.BLUE)
                } else {
                    childAt.setTextColor(Color.BLACK)
                    childAt.iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }
            switchFragement(index)
        }
        //使其默认指向第一个按钮
        tab_group.check(R.id.tab_1)
    }

    //定义fragment
    private var homeFragment:HomeFragment?=null
    private var newsFragment: NewsFragment?=null
    private var userFragment: UserFragment?=null
    //用于避免fragment重合到一起
    private var ShowFragment: Fragment?=null
    //将按钮与fragment绑定
    private fun switchFragement(index: Int) {
        //让返回值变为fragment
        val fragment = when(index){
            0->{
                if (homeFragment == null){
                    homeFragment = HomeFragment()
                }
                homeFragment
            }
            1 ->{
                if (newsFragment == null){
                    newsFragment = NewsFragment()
                }
                newsFragment
            }

            2->{
                if (userFragment == null){
                    userFragment = UserFragment()
                }
                userFragment
            }
            else -> {
                return
            }
        }?:return
        //开启fragment事务管理
        val ft = supportFragmentManager.beginTransaction()
        //判断返回的fragment中是否被绑定
        if (!fragment.isAdded){
            ft.add(R.id.container,fragment)
        }
        //显示被选中的fragment
        ft.show(fragment)
        //避免所有fragment重合
        if (ShowFragment!=null){
            ft.hide(ShowFragment!!)
        }
        ShowFragment = fragment
        //提交事务
        ft.commitAllowingStateLoss()


    }
}