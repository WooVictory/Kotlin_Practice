package woo.sopt22.kotlinexam.WebView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*
import woo.sopt22.kotlinexam.R

class WebViewActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            naverBtn->{
                webView.loadUrl("https://www.naver.com")
            }
            daumBtn->{
                webView.loadUrl("https://www.daum.net")
            }
            googleBtn->{
                webView.loadUrl("https://www.google.com")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        naverBtn.setOnClickListener(this)
        daumBtn.setOnClickListener(this)
        googleBtn.setOnClickListener(this)

        webView.webViewClient = WebViewClient() // webView에 WebViewClient 클래스를 할당하고 초기화


    }
}
