package com.example.ccccccc.ui.shequ

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import androidx.core.content.FileProvider
import com.example.ccccccc.R
import com.example.ccccccc.ui.start.HiRetrofit
import kotlinx.android.synthetic.main.activity_shequ.*
import java.io.ByteArrayOutputStream
import java.io.File

class ShequActivity : AppCompatActivity() {
    val takePhoto = 1
    val fromAlbum = 2
    lateinit var imageUri: Uri
    lateinit var outputImage: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shequ)
        takePhotoBtn.setOnClickListener {
            // 创建File对象，用于存储拍照后的图片
            outputImage = File(externalCacheDir, "output_image.jpg")
            if (outputImage.exists()) {
                outputImage.delete()
            }
            outputImage.createNewFile()
            imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(this, "com.example.cameraalbumtest.fileprovider", outputImage)
            } else {
                Uri.fromFile(outputImage)
            }
            // 启动相机程序
            val intent = Intent("android.media.action.IMAGE_CAPTURE")
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, takePhoto)
        }
        fromAlbumBtn.setOnClickListener {
            // 打开文件选择器
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            // 指定只显示图片
            intent.type = "image/*"
            startActivityForResult(intent, fromAlbum)

    }
        ok.setOnClickListener {
            val data: SharedPreferences = getSharedPreferences("data",
                Context.MODE_PRIVATE)!!
            val dname=data.getString("name","")
            val masage=neirong.text.toString()
            val intent=Intent(this,ShequActivity2::class.java).apply {
                putExtra("name","$dname")
                putExtra("massage","$masage")


            }
     startActivity(intent)


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            takePhoto -> {
                if (resultCode == Activity.RESULT_OK) {
                    // 将拍摄的照片显示出来
                    val bitmap = BitmapFactory.decodeStream(contentResolver.
                    openInputStream(imageUri))
                    imageView.setImageBitmap(rotateIfRequired(bitmap))

                }
            }
            fromAlbum -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    data.data?.let { uri ->
                        // 将选择的图片显示
                        val bitmap:Bitmap? = getBitmapFromUri(uri)
                        val intent1=Intent(this,ShequActivity2::class.java)
                   intent1.putExtra("bitmap",bitmap)
                        ok.setOnClickListener {
                            startActivity(intent1)
                        }

                    }
                }

            }
        }
    }
    fun bitmapToString(bitmap: Bitmap): String? {
        //将Bitmap转换成字符串
        var string: String? = null
        val bStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream)
        val bytes = bStream.toByteArray()
        string = Base64.encodeToString(bytes, Base64.DEFAULT)
        return string
    }
    fun stringToBitmap(string: String?): Bitmap? {
        // 将字符串转换成Bitmap类型
        var bitmap: Bitmap? = null
        try {
            val bitmapArray: ByteArray
            bitmapArray = Base64.decode(string, Base64.DEFAULT)
            bitmap = BitmapFactory.decodeByteArray(
                bitmapArray, 0,
                bitmapArray.size
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    private fun getBitmapFromUri(uri: Uri) = contentResolver
        .openFileDescriptor(uri, "r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }

    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL)
        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
            else -> bitmap
        }
    }
    private fun getbitmap(){
        val intent=Intent(this,ShequActivity2::class.java)

//        var baos = ByteArrayOutputStream()
//        if (bitmap1 != null) {
//            bitmap1.compress(Bitmap.CompressFormat.PNG,100,baos)
//        }
//        var byteArray = baos.toByteArray()
//        Log.d("AAA",byteArray.toString())

    }

    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height,
            matrix, true)
        bitmap.recycle() // 将不再需要的Bitmap对象回收
        return rotatedBitmap
    }
}