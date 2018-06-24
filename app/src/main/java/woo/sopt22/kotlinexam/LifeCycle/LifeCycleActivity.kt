package woo.sopt22.kotlinexam.LifeCycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import woo.sopt22.kotlinexam.R
import woo.sopt22.kotlinexam.Util.ToaskMaker

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onStart() {
        super.onStart()
        ToaskMaker.makeShortToast(this, "1단계 : 액티비티가 생성될 때 호출됩니다.")
    }

    override fun onResume() {
        super.onResume()
        ToaskMaker.makeShortToast(this, "2단계 : 액티비티가 화면에 나타나고 호출됩니다.")
    }

    override fun onPause() {
        super.onPause()
        ToaskMaker.makeShortToast(this, "3단계 : 액티비티가 사라지기 전에 호출되거나 반만 가려지거나 반투명 상태에 호출됩니다.")
    }

    override fun onStop() {
        super.onStop()
        ToaskMaker.makeShortToast(this, "1단계 : 액티비티가 사라진 이후에 호출된니다.")
        // 즉, 백그라운드에 갔을 때 호출된다.
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
        ToaskMaker.makeShortToast(this, "1단계 : 액티비티가 완전히 메모리에서 제거될 때 호출됩니다.")
    }


}
