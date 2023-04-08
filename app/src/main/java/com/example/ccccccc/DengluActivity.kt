package com.example.ccccccc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ccccccc.HTTP.HiOkhttp
import com.example.ccccccc.R
import com.example.ccccccc.ui.notifications.NotificationsFragment
import com.example.ccccccc.xiaxian.BaseActivity
import kotlinx.android.synthetic.main.activity_denglu.*
import kotlinx.android.synthetic.main.activity_register.*

class DengluActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denglu)


        val name = accountEdit.text.toString()
//        创建读取数据
val prefs= getSharedPreferences("$name", Context.MODE_PRIVATE)
//        初始化记住密码选择按钮
        val isRemember = prefs.getBoolean("remember_password", false)
//点击登录事件
        if (isRemember) {
            //        创建读取数据
            val data= getSharedPreferences("data", Context.MODE_PRIVATE)
            val name1=data.getString("name","")
            val prefs= getSharedPreferences("$name1 ", Context.MODE_PRIVATE)
            // 将账号和密码都设置到文本框中
            val account = prefs.getString("name", "")
            Log.d("aaaa","$account")
            val password = prefs.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }
        button_denglu.setOnClickListener {
            val name= accountEdit.text.toString()
            val password=passwordEdit.text.toString()
            val prefs= getSharedPreferences("$name", Context.MODE_PRIVATE)
            // 将账号和密码都设置到文本框中
            val Name = prefs.getString("name", "")
            val Password = prefs.getString("password", "")
            if (name==Name && password==Password) {
                val data= getSharedPreferences("data", Context.MODE_PRIVATE).edit()
                data.putString("name","$name")
                data.apply()
                data.commit()
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                val editor = getSharedPreferences("$name", Context.MODE_PRIVATE).edit()
                if (rememberPass.isChecked) { // 检查复选框是否被选中
                    editor.putBoolean("remember_password", true)
                    editor.putString("name", name)
                    editor.putString("password", password)

                } else {
                    editor.clear()
                }
                editor.apply()
                editor.commit()
            }else
            Toast.makeText(this, "账号或密码不正确", Toast.LENGTH_SHORT).show()
        }


        button_regiter.setOnClickListener {

                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)


        }
    }

}
