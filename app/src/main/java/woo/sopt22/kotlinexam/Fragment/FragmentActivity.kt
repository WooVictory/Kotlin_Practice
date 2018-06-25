package woo.sopt22.kotlinexam.Fragment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*
import woo.sopt22.kotlinexam.R

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        replaceFragment(MyFragment())

        changeBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.fragmentLayout1, fragment)
        transaction.commit()

    }
}
