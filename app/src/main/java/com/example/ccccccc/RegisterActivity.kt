package com.example.ccccccc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ccccccc.xiaxian.BaseActivity
import kotlinx.android.synthetic.main.activity_denglu.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        button_finish.setOnClickListener {
            val phone=edit_phone.text.toString()
            if(phone.isEmpty())
            {
                Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show()
            }
            val password=edit_possword.text.toString()
            if (phone.isEmpty())
            {
                Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show()
            }
            val shengao=edit_shengao.text.toString()
//判断输入美容是否为空
            if(shengao.isEmpty())
            {
                Toast.makeText(this,"请输入身高",Toast.LENGTH_SHORT).show()
            }
            val tizhong=edit_tizhong.text.toString()
            //判断输入美容是否为空
            if(tizhong.isEmpty())
            {
                Toast.makeText(this,"请输入体重",Toast.LENGTH_SHORT).show()
            }
            val age=edit_age.text.toString()
            //判断输入美容是否为空
            if(age.isEmpty())
            {
                Toast.makeText(this,"请输入年龄",Toast.LENGTH_SHORT).show()
            }
            val name=edit_diyname.text.toString()
            //判断输入美容是否为空
            if(name.isEmpty())
            {
                Toast.makeText(this,"请输入账号名",Toast.LENGTH_SHORT).show()
            }
            val BIM:Float=(tizhong.toFloat()/(shengao.toFloat()*shengao.toFloat()))*10000
            val editor = getSharedPreferences("$name", Context.MODE_PRIVATE).edit()
            editor.putString("phone", "$phone")
        editor.putString("password", "$password")
            editor.putFloat("tizhong",tizhong.toFloat())
            editor.putFloat("shengao", shengao.toFloat())
            editor.putString("age", "$age")
            editor.putString("name", name)

            editor.putFloat("BIM",BIM)

            wai.setOnClickListener {
                editor.putInt("NEI", 2)
                editor.apply()
            }
            lao.setOnClickListener {
                editor.putInt("NEI", 3)
                editor.apply()
            }
            editor.apply()
            editor.apply()


        }
        nei.setOnClickListener {
            val name=edit_diyname.text.toString()
            val editor = getSharedPreferences("$name", Context.MODE_PRIVATE).edit()
            editor.putInt("NEI", 1)
            editor.apply()
        }
        back.setOnClickListener {
            val intent=Intent(this,DengluActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
finish()
    }
}




