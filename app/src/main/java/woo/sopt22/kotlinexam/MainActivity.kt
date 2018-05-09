package woo.sopt22.kotlinexam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var json = "{ \"name\":\"John\", \"age\":31, \"city\":\"New York\" }"
        var gson = Gson()
        var userDTO = gson.fromJson(json, UserDTO::class.java)

        println(userDTO.name)
        println(userDTO.age.toString())
        println(userDTO.city)

        val JSON = MediaType.parse("application/json; charset=utf-8")

        val client = OkHttpClient()
        var url = "https://openapi.naver.com/v1/papago/n2mt"
        var json1 = JSONObject()
        json1.put("source","ko") // 번역할 언어
        json1.put("target","en") // 번역될 언어
        json1.put("text","만나서 반갑습니다.") // 언어
        val body = RequestBody.create(JSON, json1.toString())
        val request = Request.Builder()
                .header("X-Naver-Client-Id","5kX_IZWQ8N2QpmjBM6Y9")
                .addHeader("X-Naver-Client-Secret","324O7z6fB9")
                .url(url)
                .post(body)
                .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                var str = response!!.body()!!.string()
                println(str)
                var papagoDTO = Gson().fromJson<PapagoDTO>(str, PapagoDTO::class.java)
                println(papagoDTO.message!!.result!!.translatedText)

            }

        })
        recyclerview.adapter = MyRecyclerviewAdapter()
        recyclerview.layoutManager = GridLayoutManager(this,3)

    }
    inner class MyRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var imageview = ImageView(this@MainActivity)
            var params = LinearLayout.LayoutParams(parent!!.measuredWidth/3,parent!!.measuredWidth/3)
            imageview.layoutParams = params
            imageview.scaleType = ImageView.ScaleType.FIT_XY
            return CustomHolder(imageview)
        }

        inner class CustomHolder(imageview : ImageView) : RecyclerView.ViewHolder(imageview){

        }

        override fun getItemCount(): Int {
            return Images().imageUrls.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Picasso.get().load(Images().imageUrls[position]).into(holder!!.itemView as ImageView)
            // 메모리 관리 / 캐시 관리를 스스로 하기 때문에 개발자가 편리하게 사용할 수 있다.
            // 편리하게 이미지를 불러올 수 있다.

        }

    }
}
