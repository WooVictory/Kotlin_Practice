package woo.sopt22.kotlinexam.SnackBarToast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_snack_toast.*
import woo.sopt22.kotlinexam.R

class SnackToastActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            snackBtn->{
                Snackbar.make(mainView,"스낵바 메시지",Snackbar.LENGTH_LONG).show()
                // SnackBar는 Context 위에 바로 넘겨주지 않고 Context위에 있는 레이아웃에 SnackBar를 넘겨줌으롰머 조금 더 세밀하게 토스트 박스를 표시할 수 있습니다.
            }
            toastBtn->{
                Toast.makeText(this, "토스트 메시지",Toast.LENGTH_LONG).show()
                // Lengt_long : 3.5초간 토스트 메시지를 보여주겠다는 의미
                // LENGTH_SHORT : 2초간 토스트 메시지를 보여주겠다는 의미
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_toast)
        snackBtn.setOnClickListener(this)
        toastBtn.setOnClickListener(this)
    }
}
