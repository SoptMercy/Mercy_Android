package com.mercyteam.mercy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        //머리
        txt_btn_home_head.setOnClickListener {
            val intent = Intent(this,SelectActivity::class.java)
            intent.putExtra("select","head")
            startActivity(intent)
        }

        //생리통
        txt_btn_home_cramps.setOnClickListener {

        }

        //소화기
        txt_btn_home_digestive.setOnClickListener {
            val intent = Intent(this,SelectActivity::class.java)
            intent.putExtra("select","digestive")
            startActivity(intent)
        }

        //호흡기
        txt_btn_home_respiratory.setOnClickListener {
            val intent = Intent(this,SelectActivity::class.java)
            intent.putExtra("select","respiratory")
            startActivity(intent)
        }

        //기타
        txt_btn_home_etc.setOnClickListener {
            val intent = Intent(this,SelectActivity::class.java)
            intent.putExtra("select","etc")
            startActivity(intent)
        }
    }

}