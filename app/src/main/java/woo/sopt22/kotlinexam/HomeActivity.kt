package woo.sopt22.kotlinexam

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import woo.sopt22.kotlinexam.GoogleMap.GoogleMapActivity
import woo.sopt22.kotlinexam.Picker.DateTimePickerActivity
import woo.sopt22.kotlinexam.WebView.WebViewActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            pickerBtn->{
                startActivity(Intent(applicationContext, DateTimePickerActivity::class.java))
            }
            webViewBtn->{
                startActivity(Intent(applicationContext, WebViewActivity::class.java))
            }
            mapBtn->{
                startActivity(Intent(applicationContext, GoogleMapActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pickerBtn.setOnClickListener(this)
        webViewBtn.setOnClickListener(this)
        mapBtn.setOnClickListener(this)
    }
}
