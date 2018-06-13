package woo.sopt22.kotlinexam.VideoView

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*
import woo.sopt22.kotlinexam.R

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        supportActionBar!!.hide() // 액션바 숨기기
        // 외부 url에 접근하기 위해서는 인터넷 접근 권한이 필요하다.
        // 그렇기 때문에 Manifest 파일에 인터넷 권한을 추가해준다.
        var url = Uri.parse("https://www.rmp-streaming.com/media/bbb-360p.mp4")
        videoView.setVideoURI(url)
        videoView.start()

        var controller = MediaController(this)
        videoView.setMediaController(controller)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) { // 포커스가 변경될 때
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
            // 네비게이션바와 상태바를 안보이도록 설정

        }
    }
}
