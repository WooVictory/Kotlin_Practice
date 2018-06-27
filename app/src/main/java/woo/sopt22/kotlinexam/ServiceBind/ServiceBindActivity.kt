package woo.sopt22.kotlinexam.ServiceBind

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_service_bind.*
import woo.sopt22.kotlinexam.R

class ServiceBindActivity : AppCompatActivity(), ServiceConnection, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            serviceStateBtn->{
                if(isService){
                    Toast.makeText(this, "서비스가 연결이 완료 되어있습니다. ", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "서비스가 연결이 해제 되어있습니다. ", Toast.LENGTH_SHORT).show()
                }
            }
            serviceDetachBtn->{
                /*FIXME
                * unBind() 한다고 onServiceDisconnected()이 바로 호출되지 않습니다.
                * 이것이 호출되는 타이밍은 OS가 메모리를 저장하기 위해서 서비스를 죽이기로 결정했을 때 호출된다.
                * unBind() 된다고 서비스가 죽지는 않기 때문에 호출되지 않습니다.
                * 그래서 isService 값을 false로 바꿔줍니다.
                * */
                if(isService){
                    unbindService(this)
                    isService = false
                }
            }
        }
    }

    var isService = false
    override fun onServiceDisconnected(name: ComponentName?) {
        // 서비스 연결이 해제되었을 때 호출되는 부분
        isService = false
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        // 서비스 연결이 되었을 때 호출되는 부분
        // service에서 서비스가 넘어옵니다. 넘어온 것을 캐스팅해줍니다.

        var myBinder = service as MyService.MyBinder
        var service = myBinder.getService()
        Toast.makeText(applicationContext, service.message, Toast.LENGTH_SHORT).show()
        isService = true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_bind)

        var service = Intent(this, MyService::class.java)
        bindService(service,this, Context.BIND_AUTO_CREATE)
        // 서비스를 바인드 시켜줍니다.
        /*FIXME
        * 즉, 서비스와 앱을 연결시켜주었습니다.
        * bindService를 실행하게 되면 서비스와 Activity가 연결됩니다.
        * 그리고 연결된 결과값을 가져오는 부분은 this를 넣어주어서 this가 ServiceConnection 인터페이스를 구현할 때
        * 오버라이드한 함수들과 연결됩니다.
        * 그리고 Context.BIND_AUTO_CREATE는 서비스가 살아있는 상태가 아니라면 생성한다는 의미를 가지고 있습니다.
        * */
        serviceStateBtn.setOnClickListener(this)
        serviceDetachBtn.setOnClickListener(this)

    }
}
