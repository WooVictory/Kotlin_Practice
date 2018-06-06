package woo.sopt22.kotlinexam.Recyclerview2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*
import woo.sopt22.kotlinexam.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        lee_recyclerview.adapter = MainRecyclerAdapter()
        lee_recyclerview.layoutManager = LinearLayoutManager(this) // 리스트 형태의 리사이클러뷰



    }
    class MainRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        var images = arrayOf(R.drawable.rail01,R.drawable.rail02,R.drawable.rail03,R.drawable.rail04)
        var titles = arrayOf("프랑크프루트","런던","파리","프라하")
        var countries = arrayOf("독일","영국","프랑스","체코")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
            return CustomViewHolder(view)

        }

        class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            var imageView : ImageView? = null
            var textView1  : TextView? = null
            var textView2 : TextView? = null
            init {
                imageView = itemView.findViewById(R.id.profile)
                textView1 = itemView.findViewById(R.id.title)
                textView2 = itemView.findViewById(R.id.country)
            }
        }

        override fun getItemCount(): Int {
            return images.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var view = holder as CustomViewHolder
            view.imageView!!.setImageResource(images[position])
            view.textView1!!.text = titles[position]
            view.textView2!!.text = countries[position]
        }

    }
}
