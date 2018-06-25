package woo.sopt22.kotlinexam.Context

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_context.*
import woo.sopt22.kotlinexam.R

class ContextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)
        replaceFragment(ImFragment())
        Toast.makeText(this,"토스트 메시지입니다.", Toast.LENGTH_SHORT).show()
        /*FIXME
        * Activity라는 친구는 Context를 가지고 있다.
        * 그렇기 때문에 this는 Class 즉, AppCompatActivity()를 지칭하기 때문에 받아올 수 있다.
        * */
    }
    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.contextFrame, fragment)
        transaction.commit()

    }
}
