package com.mercyteam.mercy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_home.adapter = RecommendAdapter(
            supportFragmentManager, 2
        )
        vp_home.offscreenPageLimit = 2
        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                //네비게이션 메뉴 아이템 체크
                //bottomNavigationView.menu.getItem(position).isChecked = true

            }

        })

//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.menu_home -> main_viewPager.currentItem = 0
//                R.id.menu_book -> main_viewPager.currentItem = 1
//                R.id.menu_person -> main_viewPager.currentItem = 2
//            }
//            true
//        }
    }
}
