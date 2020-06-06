package com.mercyteam.mercy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_result)


        val intent = intent
        val img = intent.getStringExtra("img")
        Glide.with(this).load(img).into(imageView5)
    }
}