package woo.sopt22.kotlinexam.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyServiece : Service() {
    // 서비스가 생성될 때 작동 [서비스가 처음 만들어졌을 때 작동]
    override fun onCreate() {
        super.onCreate()
    }
    // 서비스가 생성되기 직전에 작동 [서비스가 만들어졌는데 또 실행되었을 때]
    // onStart(), onResume() 처럼 서비스가 생성이 되는데 다시 실행시킬 때만 이쪽 부분이 작동
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread{
            run {
                while(true){
                    Thread.sleep(3000)
                    println("서비스 실행 중 입니다.")
                }
            }
        }.start()

        return START_STICKY
        /*FIXME
        * 서비스가 특정 오류로 종료되어도 찐득이처럼 서비스가 되살아나도록 설정해주는 Flag 값입니다.
        * */
    }
    // 서비스가 제거될 때 작동
    override fun onDestroy() {
        super.onDestroy()
    }
    //
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}