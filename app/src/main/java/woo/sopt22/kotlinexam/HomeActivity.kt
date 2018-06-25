package woo.sopt22.kotlinexam

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import woo.sopt22.kotlinexam.Async.AsyncTaskActivity
import woo.sopt22.kotlinexam.Dialog.DialogActivity
import woo.sopt22.kotlinexam.FCM.FCMActivity
import woo.sopt22.kotlinexam.Fragment.FragmentActivity
import woo.sopt22.kotlinexam.Fragment.FragmentLifeCycleActivity
import woo.sopt22.kotlinexam.GoogleMap.GoogleMapActivity
import woo.sopt22.kotlinexam.Handler.HandlerActivity
import woo.sopt22.kotlinexam.Intent.IntentActivity
import woo.sopt22.kotlinexam.Picker.DateTimePickerActivity
import woo.sopt22.kotlinexam.RequestPermission.RequsetPermissionActivity
import woo.sopt22.kotlinexam.Service.ServiceActivity
import woo.sopt22.kotlinexam.SharedPreference.SharedPreferenceActivity
import woo.sopt22.kotlinexam.SnackBarToast.SnackToastActivity
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
            intentBtn->{
                startActivity(Intent(applicationContext, IntentActivity::class.java))
            }
            requestPermissionBtn->{
                startActivity(Intent(applicationContext, RequsetPermissionActivity::class.java))
            }
            fragmentBtn->{
                startActivity(Intent(applicationContext, FragmentActivity::class.java))
            }
            dialogBtn->{
                startActivity(Intent(applicationContext, DialogActivity::class.java))
            }
            fragmentLifeBtn->{
                startActivity(Intent(applicationContext, FragmentLifeCycleActivity::class.java))
            }
            snackBarToastBarBtn->{
                startActivity(Intent(applicationContext, SnackToastActivity::class.java))
            }
            sharedPreferenceBtn->{
                startActivity(Intent(applicationContext, SharedPreferenceActivity::class.java))
            }
            handlerBtn->{
                startActivity(Intent(applicationContext, HandlerActivity::class.java))
            }
            asyncBtn->{
                startActivity(Intent(applicationContext, AsyncTaskActivity::class.java))
            }
            tokenBtn->{
                startActivity(Intent(applicationContext, FCMActivity::class.java))
            }
            serviceBtn->{
                startActivity(Intent(applicationContext, ServiceActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pickerBtn.setOnClickListener(this)
        webViewBtn.setOnClickListener(this)
        mapBtn.setOnClickListener(this)
        intentBtn.setOnClickListener(this)
        requestPermissionBtn.setOnClickListener(this)
        fragmentBtn.setOnClickListener(this)
        dialogBtn.setOnClickListener(this)
        fragmentLifeBtn.setOnClickListener(this)
        snackBarToastBarBtn.setOnClickListener(this)
        sharedPreferenceBtn.setOnClickListener(this)
        handlerBtn.setOnClickListener(this)
        asyncBtn.setOnClickListener(this)
        tokenBtn.setOnClickListener(this)
        serviceBtn.setOnClickListener(this)
    }
}
