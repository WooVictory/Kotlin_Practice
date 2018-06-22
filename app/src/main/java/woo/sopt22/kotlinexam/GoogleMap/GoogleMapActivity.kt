package woo.sopt22.kotlinexam.GoogleMap

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import woo.sopt22.kotlinexam.R

class GoogleMapActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onMapReady(p0: GoogleMap?) {
        // Map 로딩이 완료되었을 때 발생되는 함수
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            // 두 개의 권한을 받아왔으면
            p0!!.isMyLocationEnabled = true

        }
    }

    var mapFragment : MapFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION),100)
        mapFragment = fragmentManager.findFragmentById(R.id.mapFragment) as MapFragment

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        // 권한을 추가했을 때 다음 단계로 넘어가는 부분
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // 권한 허가
            /*FIXME
            * 권한이 허가되었을 때 위에서 구현한 OnMapReadyCallback 인터페이스(onMapReady() 함수)와 연결해준다.
            * */
            mapFragment!!.getMapAsync(this)
            /*FIXME
            * this는 위에서 구현한 OnMapReadyCallback 인턴페이스를 가리키며
            * 가리킨 것은 OnMapReady() 함수로 넘어가게 되면서 현재 내 위치로 이동할 수 있는 버튼을 만들게 된다.
            *
            * */


        }
    }
}
