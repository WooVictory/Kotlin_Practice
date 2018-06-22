package woo.sopt22.kotlinexam.Picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_date_time_picker.*
import woo.sopt22.kotlinexam.R
import java.util.*

class DateTimePickerActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            datePickerBtn->{
                showDatePicker()
            }
            timePickerBtn->{
                showTimePicker()
            }
        }
    }


    var cal = Calendar.getInstance() // 현재 시각 받아옴

    companion object {
        var years : String?=null
        var months : String?=null
        var days : String?=null

        var times : String?=null
        var minutes : String?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker)
        datePickerBtn.setOnClickListener(this)

        timePickerBtn.setOnClickListener(this)
    }

    fun showDatePicker(){
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            val y = year
            val m = month
            val d = dayOfMonth

            years = year.toString()
            months = month.toString()
            days = dayOfMonth.toString()

            Toast.makeText(this, years+"년"+ months+"월"+ days+"일", Toast.LENGTH_LONG).show()
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)).show()
    }


    fun showTimePicker(){
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

            val t = hourOfDay
            val mi = minute

            times = t.toString()
            minutes = mi.toString()

            Toast.makeText(this, times+"시"+ minutes+"분", Toast.LENGTH_LONG).show()


        }
                ,cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),true).show()

        // boolean 값을 true로 함으로써 시간은 24시간으로 지정

    }
}
