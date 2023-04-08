package com.example.ccccccc.ui.dati

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.ccccccc.R
import kotlinx.android.synthetic.main.activity_lianjie.*

class LianjieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lianjie)
        val lianjie=intent.getStringExtra("lianjie")
        webView.settings.javaScriptEnabled=true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("$lianjie")
    }
}