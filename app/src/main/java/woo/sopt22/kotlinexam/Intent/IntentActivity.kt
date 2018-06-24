package woo.sopt22.kotlinexam.Intent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.*
import woo.sopt22.kotlinexam.R
import woo.sopt22.kotlinexam.Util.ToaskMaker

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        button.setOnClickListener {
            var bActivityIntent : Intent = Intent(applicationContext, BActivity::class.java)
            startActivity(bActivityIntent)
        }

    }

    override fun onStart() {
        super.onStart()
        ToaskMaker.makeShortToast(this, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        ToaskMaker.makeShortToast(this, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        ToaskMaker.makeShortToast(this, "onPause()")

    }
}
