package com.mercyteam.mercy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.fragment_recommend.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        val intent: Intent = getIntent()
        val img=intent.getStringExtra("img")

        Glide.with(this).load(img).into(imageView5)
        txt_btn_payment.setOnClickListener {
            val intent = Intent(this,PaymentResultActivity::class.java)
            intent.putExtra("img",img)
            startActivity(intent)
        }
    }
}