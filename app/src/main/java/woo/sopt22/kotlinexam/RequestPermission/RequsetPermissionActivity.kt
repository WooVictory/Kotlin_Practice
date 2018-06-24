package woo.sopt22.kotlinexam.RequestPermission

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import woo.sopt22.kotlinexam.R

class RequsetPermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requset_permission)

        var calendar = Manifest.permission.READ_CALENDAR
        var camera = Manifest.permission.CAMERA
        var contact = Manifest.permission.READ_CONTACTS

        var location = Manifest.permission.ACCESS_FINE_LOCATION
        var microphone = Manifest.permission.RECORD_AUDIO
        var phone = Manifest.permission.READ_PHONE_STATE

        var sensor = Manifest.permission.BODY_SENSORS
        var sms = Manifest.permission.SEND_SMS
        var storage = Manifest.permission.READ_EXTERNAL_STORAGE
        // Manifest에 접근해서 Permission을 받아왔다.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(calendar,camera,contact,location,microphone,phone,sensor,sms,storage),100)
        }
        // 마시멜로우 버전 단말기 이상에서만 이 코드가 동작된다.
    }

    /*FIXME
    * 아래의 함수는 권한을 받았는지 안 받았는지 확인할 수 있는 함수입니다.
    * 만약, 권한을 받지 않았다면 권한을 받기 위해서 사용자한테 알림 메시지를 띄워줘야 할 때 유용하게 사용할 수 있는 부분입니다.
    * permissions : 권한에 대한 이름이 나온다.
    * grantResults : 그 권한을 받았는지 안 받았는지 알려주는 매개변수입니다. 이 값을 통해서 개발자가 권한을 받았는지 안 받았는지 상태 값으로 쉽게 구분할 수 있습니다.
    * */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 100){
            for(i in permissions.indices){
                println("권한 : "+ permissions[i]+ "허가 상태 : "+grantResults[i])
            }
        }
    }
}
