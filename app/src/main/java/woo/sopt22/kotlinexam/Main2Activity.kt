package woo.sopt22.kotlinexam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import io.realm.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

open class Item : RealmObject(){
    open var name : String?=null
}
class Main2Activity : AppCompatActivity() {
    var shoppingList = mutableListOf<Item>() // 자바 : List<Item>과 같은 개념이라고 생각하면 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        main2_recycler.adapter = RcAdapter()
        main2_recycler.layoutManager = LinearLayoutManager(this)
        Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        // Realm의 데이터 스키마가 초기화되었을 때 알려주는 것

        var realm = Realm.getInstance(config)
        main2_btn.setOnClickListener {
            realm.beginTransaction()
            var item = realm.createObject(Item::class.java)
            item.name = main2_search.text.toString()
            realm.commitTransaction()

        }

        // 데이터가 바뀔 때마다 이벤트가 발생하는 인터페이
        // 데이터가 입력되거나 수정되거나 삭제될 때 발생하는 부분을 처리함
        realm.where(Item::class.java).findAll().addChangeListener {
            t: RealmResults<Item>?, changeSet: OrderedCollectionChangeSet? ->
            shoppingList.clear()
            shoppingList.addAll(t!!)
            main2_recycler.adapter.notifyDataSetChanged()

        }


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
