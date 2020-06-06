package com.mercyteam.mercy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        val recommentAdapter = RecommendAdapter(supportFragmentManager, 3)
        vp_home.run {
            adapter = recommentAdapter
            offscreenPageLimit = 2
        }
        tl_home.setupWithViewPager(vp_home)
    }
}
