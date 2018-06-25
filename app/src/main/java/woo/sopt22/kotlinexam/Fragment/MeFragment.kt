package woo.sopt22.kotlinexam.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import woo.sopt22.kotlinexam.R

class MeFragment : Fragment() {

    // 시작할 때
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.mefragment, container, false)
        return view
    }
    // 프래그먼트가 뷰에 나타나기 전에
    override fun onStart() {
        super.onStart()
    }
    // 프래그먼트가 뷰에 나타난 상태
    override fun onResume() {
        super.onResume()
    }
    // 프래그먼트 반만 가려진 상태
    override fun onPause() {
        super.onPause()
    }
    // 프래그먼트 정지
    override fun onStop() {
        super.onStop()
    }
    // 프래그먼트 제거
    override fun onDetach() {
        super.onDetach()
    }
}