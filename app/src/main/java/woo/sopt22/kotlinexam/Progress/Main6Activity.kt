package woo.sopt22.kotlinexam.Progress

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main6.*
import woo.sopt22.kotlinexam.R

class Main6Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            button1->{
                progressBar1.visibility = View.INVISIBLE
            }
            button2->{
                var i = 0
                object : AsyncTask<Void, Void, Void>(){
                    override fun doInBackground(vararg params: Void?): Void? {

                        while(i <=100){
                            progressBar2.setProgress(i)
                            i++
                            Thread.sleep(100) // 0.1초 쉬어줌

                        }
                        return null
                    }

                }.execute()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }
}
