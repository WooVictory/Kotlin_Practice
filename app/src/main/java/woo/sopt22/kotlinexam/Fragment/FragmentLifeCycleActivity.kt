package woo.sopt22.kotlinexam.Fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_fragment_life_cycle.*
import woo.sopt22.kotlinexam.R
import woo.sopt22.kotlinexam.Util.ToaskMaker

class FragmentLifeCycleActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            deleteBtn->{

                removeFragment(MeFragment())
                ToaskMaker.makeShortToast(applicationContext, "삭제함")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_life_cycle)

        replaceFragment(MeFragment())
        deleteBtn.setOnClickListener(this)
    }


    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.commit()

    }

    fun removeFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.remove(fragment)
        transaction.commit()
    }
}
