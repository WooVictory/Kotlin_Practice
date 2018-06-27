package woo.sopt22.kotlinexam.ServiceBind

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service(){

    var message : String?=null

    override fun onCreate() {
        super.onCreate()
        message = "서비스가 작동 중 입니다."
    }
    // 서비스가 만들어짐


    /*FIXME
    * App이랑 연결되야 하는데 연결되는 부분이 onBind() 함수 부분입니다.
    * 그래서 Service를 통째로 넘겨줘야 하는데, 그냥 넘길 수는 없고, Bind를 통해서 넘겨줘야 합니다.
    * */

    inner class MyBinder : Binder(){

        fun getService() : MyService{
            return this@MyService
        }
    }

    // inner 클래스를 통해서 Service에 접근할 수 있도록 하였습니다.

    override fun onBind(intent: Intent?): IBinder {
        return MyBinder()
        /*FIXME
        *
        * */

    }

    // 앱과 서비스가 연결이 끊겼을 때 호출되는 부분
    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    // 서비스가 사라졌을 때 호출되는 부분
    override fun onDestroy() {
        super.onDestroy()
    }
}