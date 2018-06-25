package woo.sopt22.kotlinexam.SharedPreference

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_shared_preference.*
import woo.sopt22.kotlinexam.R

class SharedPreferenceActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var edit = sharedPreferences.edit() // sharedPreference를 수정할 수 있는 변수 edit


        var saveString = sharedPreferences.getString("userId","아이디를 입력해주세요.")
        // 저장된 id를 불러온다. 하지만, 저장된 id가 없다면, null 값이 들어오게 되어서 에러가 발생한다.
        // 이를 방지하기 위해서 default 값이 존재하는 것이고 저장된 값이 없을 경우, default 값을 불러온다.
        editTextEmail.setText(saveString)
        saveBtn.setOnClickListener {
            edit.putString("userId",editTextEmail.text.toString()).commit()
        }
    }
}

