package woo.sopt22.kotlinexam.ViewPager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main4.*
import woo.sopt22.kotlinexam.R

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        lee_viewpager.adapter = leeViewPagerAdapter(supportFragmentManager)
        lee_tab.addTab(lee_tab.newTab().setText("Fragment1"))
        lee_tab.addTab(lee_tab.newTab().setText("Fragment2"))
        lee_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                lee_viewpager.setCurrentItem(tab!!.position)
            }

        })

        lee_viewpager.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(lee_tab){

        })
    }

    class leeViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){


        // 보여줄 페이지를 Array로 만들자

        var fragments = arrayOf(Fragment1(), Fragment2())

        // 페이지가 전환될 때 화면을 넣어주는 부분!
        // 다시 말해서, 페이지를 넘기듯이 슬라이드 해서 두번째 화면을 보려고 할 때, Fragment2를 보여준다.
        override fun getItem(position: Int): Fragment {
            return fragments[position]

        }

        // 페이지 갯수를 세는 부
        override fun getCount(): Int {
            return fragments.size
        }

    }
}
