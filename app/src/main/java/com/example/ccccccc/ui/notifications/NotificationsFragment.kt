package com.example.ccccccc.ui.notifications

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigator
import com.example.ccccccc.DengluActivity
import com.example.ccccccc.MainActivity
import com.example.ccccccc.R
import com.example.ccccccc.ui.Massag
import com.example.ccccccc.ui.SQLiteActivity
import com.example.ccccccc.ui.shequ.ShequActivity
import com.example.ccccccc.ui.shequ.ShequActivity2
import com.example.ccccccc.xiaxian.TizhongActivity
import kotlinx.android.synthetic.main.fragment_notifications.*
import java.util.jar.Attributes


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        return root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val data:SharedPreferences= activity?.getSharedPreferences("data",Context.MODE_PRIVATE)!!
        val dname=data.getString("name","")
        val sp:SharedPreferences= activity?.getSharedPreferences("${dname.toString()}",Context.MODE_PRIVATE)!!
        val Name=sp.getString("name","")
        name.text=Name.toString()
        val Age=sp.getString("age","")
        age.text=Age.toString()
        val Shengao=sp.getFloat("shengao",-1f)
        shengao.text=Shengao.toString()
        val Tizhog=sp.getFloat("tizhong",-1f)
        tizhong.text=Tizhog.toString()
        val bim=sp.getFloat("BIM",-1f)
        BIM.text=bim.toString()
        val Phone=sp.getString("phone","")
        phone.text=Phone.toString()
        diyname.text=dname.toString()

        tizhong1.setOnClickListener {
            val intent1=Intent(activity,TizhongActivity::class.java)
            startActivity(intent1)
        }
        shequ.setOnClickListener {
val intent=Intent(activity,ShequActivity2::class.java)
            startActivity(intent)
        }
        SQ.setOnClickListener {
            val intent=Intent(activity,SQLiteActivity::class.java)
            startActivity(intent)
        }
    }



}




