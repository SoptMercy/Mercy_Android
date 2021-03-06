package com.mercyteam.mercy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_select.*
import kotlinx.android.synthetic.main.activity_select.view.*
import kotlinx.android.synthetic.main.activity_select.view.img_head_back


class SelectActivity : AppCompatActivity() {

    lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        init()
    }

    private fun init(){
        img_head_back.setOnClickListener {
            onBackPressed()
        }

        val intent = intent
        val select = intent.getStringExtra("select")


        when(select){
            "head" -> {
                fragment = HeadFragment()
            }
            "digestive" -> {
                fragment = DigestiveFragment()
            }
            "respiratory" -> {
                fragment = RespiratoryFragment()
            }
            "etc" -> {
                fragment = EtcFragment()
            }
        }

        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fl_head_middle, fragment)
        fragmentTransaction.commit()

        txt_btn_head_recommend.setOnClickListener {
            val intent = Intent(this,RecommendActivity::class.java)
            startActivity(intent)
        }
    }
}