package woo.sopt22.kotlinexam.Handler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_handler.*
import woo.sopt22.kotlinexam.R

class HandlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

        var thread = Thread{
            run {
                Thread.sleep(3000)
                Handler(Looper.getMainLooper()).post {
                    handlerTv.setText("쓰레드 작동")

                }
            }
        }
        thread.start()

    }
}
