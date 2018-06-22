package woo.sopt22.kotlinexam.SurfaceView

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import kotlinx.android.synthetic.main.activity_surface_view.*
import woo.sopt22.kotlinexam.R

class SurfaceViewActivity : AppCompatActivity(), SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            backBtn->{
                var position = mediaPlayer!!.currentPosition - 5000
                mediaPlayer!!.seekTo(position) // 5초 전으로 돌아간다.
            }
            stopBtn->{
                mediaPlayer!!.pause()

            }
            startBtn->{
                mediaPlayer!!.start()

            }
            fastBtn->{
                var position = mediaPlayer!!.currentPosition + 5000
                mediaPlayer!!.seekTo(position) // 5초 전으로 돌아간다.

            }
        }

    }

    var surfaceHolder : SurfaceHolder?=null
    var mediaPlayer : MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surface_view)

        surfaceHolder = surfaceView.holder // surfaceHolder에 surfaceView를 담는다.
        surfaceHolder!!.addCallback(this)

        backBtn.setOnClickListener(this)
        startBtn.setOnClickListener(this)
        stopBtn.setOnClickListener(this)
        fastBtn.setOnClickListener(this)


        /*FIXME
        this의 의미는 위의 SurfaceHolder.callback 인터페이스와 연결하겠다는 의미이다.
        즉, 인터페이스를 구현함으로써 오버라이드한 함수들 surfaceChanged, surfaceDestroyed, surfaceCreated와 연결한다.
        */
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        // Surface 안에 있는 데이터가 변경되었을 때 호출되는 부분
        // 예를 들어 Surface가 스케치로 사용되었을 때 그림이 그려졌을 때 변경되기 때문에 호출된다. 영상의 경우에는 다른 영상으로 대체될 경우에 호출된다.
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        // 영상이 끝나거나 종료될 때 발생한다.
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        // SurfaceView가 만들어질 때 호출되는 부분으로 액티비티가 만들어질 떄 혹은 영상이 만들어지기 직전에 발생
        var url = "https://www.rmp-streaming.com/media/bbb-360p.mp4"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDisplay(holder)
        // mediaPlayer와 surfaceView와 연결이 되었다.
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare() // 영상을 준비해줌
        mediaPlayer!!.setOnPreparedListener(this)

        /*FIXME
        * 여기서의 this의 의미는 위에서 구현한 MediaPlayer.OnPreparedListener를 의미한다.
        * 즉, 영상이 준비가 완료되면 MediaPlayer.OnPreparedListener의 onPrepared로 넘어가서 이벤트 처리를 하면 된다.
        * */

    }

    override fun onPrepared(mp: MediaPlayer?) {
        // 영상이 준비가 완료되었을 때 호출되는 부분으로 SurfaceHolder의 인터페이스가 아니라 MediaPlayer의 인터페이스다.

        mediaPlayer!!.start()

    }

}
