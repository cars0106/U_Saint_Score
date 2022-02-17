package com.project.u_saint_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import kotlinx.android.synthetic.main.activity_web_view.*
import org.jsoup.Jsoup

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url: String = intent.getStringExtra("url").toString()
        val myJavascriptInterface = MyJavascriptInterface()

        webView.addJavascriptInterface(myJavascriptInterface, "Android")
        webView.apply {
            webViewClient = CustomWebClient()
            settings.javaScriptEnabled = true
        }

        webView.loadUrl(url)

        Log.e("parse: ", myJavascriptInterface.string)
    }

    override fun onBackPressed() {
        finish()
    }

    class MyJavascriptInterface {
        var string = ""

        @JavascriptInterface
        fun getHtml(html: String) {
            var source = html

            Log.e("html: ", source)

            val doc = Jsoup.parse(source)
            val elements = doc.select("#WD01D7")
            string = elements.toString()
        }
    }
}