package woo.sopt22.kotlinexam.Service

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import woo.sopt22.kotlinexam.R

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        var service = Intent(this, MyServiece::class.java)
        startService(service)
    }
}
