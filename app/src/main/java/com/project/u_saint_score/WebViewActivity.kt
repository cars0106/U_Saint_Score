package com.project.u_saint_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.apply {
            webViewClient = CustomWebClient()
            settings.javaScriptEnabled = true
        }

        webView.loadUrl("https://saint.ssu.ac.kr/irj/portal")
    }

    override fun onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack()
        }
        else {
            finish()
        }
    }
}