package woo.sopt22.kotlinexam.Spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main5.*
import woo.sopt22.kotlinexam.R

class SpinnerActivity : AppCompatActivity() {

    var countries = arrayOf("한국", "미국")
    var cities = arrayOf("서울","대전","부산")
    var city_usa = arrayOf("뉴욕","워싱턴","로스엔젤로스")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countries)
        // 스피너에 달 어답터를 설정해주고, 스피너에 어답터를 달아주면 끝!
        spinner_country.adapter = countryAdapter

        spinner_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{ // 아이템을 클릭했을 때 이벤트 처리
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // 아이템을 클릭했을 때 처리할 이벤트를 설정한다.
                var country = parent!!.getItemAtPosition(position) // 스피너 중에서 어떤 나라를 선택헀는지 알 수 있다.
                Log.v("11",country.toString())
                when(country){
                    "한국"->{
                        var adpater = ArrayAdapter<String>(this@SpinnerActivity, android.R.layout.simple_spinner_dropdown_item,cities)
                        // 주의할 점!! 리스너 안에서 this(context)를 넣어줄 경우에는 해당 액티비티임을 표시해주기 위해서 @ 사용
                        spinner_city.adapter = adpater
                    }
                    "미국"->{
                        var adpater = ArrayAdapter<String>(this@SpinnerActivity, android.R.layout.simple_spinner_dropdown_item,city_usa)
                        spinner_city.adapter = adpater
                    }
                }
            }
        }

        spinner_city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var country = parent!!.getItemAtPosition(position).toString() // 스피너 중에서 어떤 나라를 선택헀는지 알 수 있다.
                Toast.makeText(this@SpinnerActivity, country, Toast.LENGTH_LONG).show()
            }

        }


    }
}
