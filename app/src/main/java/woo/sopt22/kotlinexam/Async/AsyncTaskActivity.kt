package woo.sopt22.kotlinexam.Async

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_async_task.*
import woo.sopt22.kotlinexam.R

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        // params : 입력값, progress : 중간에 처리된 값, result : 최종값
        var async = object : AsyncTask<Int, Int, String>(){

            // 백그라운드로 값이 연산되는 부분
            override fun doInBackground(vararg params: Int?): String {
                /*FIXME
                * 이 부분은 비동기로 코드가 작동되는 부분입니다.
                * */

                var position = params[0]!!
                while(position < 100){
                    Thread.sleep(1000)
                    position = position + 1
                    publishProgress(position)
                    // 값이 1씩 증가할 때마다 onProgressUpdate에 넘겨준다.

                }
                return "다운로드가 완료되었습니다."
                /*FIXME
                * 최종값을 출력할 때는 return을 해주게 되면 자동적으로
                * 최종값이 onPostExecute 부분으로 넘어가게 됩니다.
                * */
            }
            // 중간값이 출력되는 부분
            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                asyncTv.text = values[0].toString() + "%"
            }
            // 최종값이 출력되는 부분
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                asyncTv.text = result!!
            }
        }
        async.execute(20)

    }
}
