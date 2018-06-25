package woo.sopt22.kotlinexam.FCM

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.iid.FirebaseInstanceId
import woo.sopt22.kotlinexam.R

class FCMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm)

        var token = FirebaseInstanceId.getInstance().token
        println(token)
    }
}
