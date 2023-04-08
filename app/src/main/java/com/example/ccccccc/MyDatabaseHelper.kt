package ui.fragment

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.ccccccc.ui.jilu.JiluFragment

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    //primary key 把id设置成主键 autoincrement自增长

    private val createFruit = "create table Fruit (" +
            " id integer primary key autoincrement," +
            "fruitname text," +     //设置水果名
            "calories real," +      //热量
            "protein real," +       //蛋白质
            "carbohydrate real,"+    //碳水化合物
            "dietary real,"+         //膳食纤维
            "na real,"+             //钠
            "fat real)"             //脂肪
    private val createZhushi = "create table Zhushi (" +
            " id integer primary key autoincrement," +
            "name text," +     //设置主食名字
            "calories real," +      //热量
            "protein real," +       //蛋白质
            "carbohydrate real,"+    //碳水化合物
            "dietary real,"+         //膳食纤维
            "na real,"+             //钠
            "fat real)"             //脂肪
    private val createShucai = "create table Shucai (" +
            " id integer primary key autoincrement," +
            "name text," +     //设置主食名字
            "calories real," +      //热量
            "protein real," +       //蛋白质
            "carbohydrate real,"+    //碳水化合物
            "dietary real,"+         //膳食纤维
            "na real,"+             //钠
            "fat real)"             //脂肪
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createFruit)
        db.execSQL(createZhushi)
        db.execSQL(createShucai)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("drop table if exists Fruit")
        db.execSQL("drop table if exists Zhushi")
        db.execSQL("drop table if exists Shucai")
        onCreate(db)
    }
}