package woo.sopt22.kotlinexam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import io.realm.RealmObject

open class Item : RealmObject(){
    open var name : String?=null
}
class Main2Activity : AppCompatActivity() {
    var shoppingList = mutableListOf<Item>() // 자바 : List<Item>과 같은 개념이라고 생각하면 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    inner class RcAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var textView = TextView(this@Main2Activity)
            return CustomViewHolder(textView)
        }

        inner class CustomViewHolder(textView: TextView) : RecyclerView.ViewHolder(textView) {


        }

        override fun getItemCount(): Int = shoppingList.size

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var textView = holder!!.itemView as TextView
            textView.text = shoppingList[position].name
        }

    }
}
