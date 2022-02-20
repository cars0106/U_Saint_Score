package com.project.u_saint_score

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import kotlinx.android.synthetic.main.activity_web_view.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class WebViewActivity : AppCompatActivity() {
    var string = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url: String = intent.getStringExtra("url").toString()
        val myJavascriptInterface = MyJavascriptInterface()

        webView.apply {
            webViewClient = CustomWebClient()
            settings.javaScriptEnabled = true
        }
        webView.addJavascriptInterface(myJavascriptInterface, "Android")

        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("grade", string)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    inner class MyJavascriptInterface {

        @JavascriptInterface
        fun getHtml(html: String) {
            val source = html

            Log.e("html: ", source)

            val doc = Jsoup.parse(source)
            val element: Elements = doc.getElementsByClass("top_user")

            Log.e("element:", element[0].text())
            string = element.text()
        }
    }
}