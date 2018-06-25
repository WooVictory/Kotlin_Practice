package woo.sopt22.kotlinexam.Context

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import woo.sopt22.kotlinexam.R

class ImFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.imfragment, container, false)
        // 이렇게 넣어주면 오류가 난다. 이유는 Fragment는 Context가 없기 때문!!
        // Toast.makeText(this,"토스트 메시지입니다.", Toast.LENGTH_SHORT).show()


        // 해결하기 가장 쉬운 방법은 activity를 넣는 것이다. 이 activity는 ContextActivity로 타고 들어가서 ContextActivity의 Context를 받아오게 된다.
        // 이게 가능한 이유는 ImFragment가 ContextActivity에 귀속이 되기 때문에 activity라고 입력을 하게 되면 이 코드는 부모 뷰라고 할 수 있는 ContextActivity로 타고 가서 Context를 받아와서
        // 여기서 준다.
        Toast.makeText(activity,"프래그먼트 토스트 메시지입니다.", Toast.LENGTH_SHORT).show()
        return view
    }
}