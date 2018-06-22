package woo.sopt22.kotlinexam.Dialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_dialog.*
import woo.sopt22.kotlinexam.R

class DialogActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            dialogBtn->{
                showDialog()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        dialogBtn.setOnClickListener(this)

    }

    fun showDialog(){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("알림")
        builder.setMessage("앱을 종료 하시겠습니까?")
        builder.setPositiveButton("예", DialogInterface.OnClickListener { dialog, which ->
            onBackPressed() // back 키 눌러서 앱 종료
        })

        builder.setNegativeButton("아니오", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        }).show()

    }

}
