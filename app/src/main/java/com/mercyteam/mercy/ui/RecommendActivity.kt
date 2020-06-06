package com.mercyteam.mercy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.semina_3st.network.customEnqueue
import com.mercyteam.mercy.R
import com.mercyteam.mercy.data.DrugData
import com.mercyteam.mercy.data.RequestRecommend
import com.mercyteam.mercy.data.ResponseRecommend
import com.mercyteam.mercy.network.RequestToServer
import kotlinx.android.synthetic.main.activity_recommend.*

class RecommendActivity : AppCompatActivity() {

    val requestToServer = RequestToServer
    lateinit var data: ArrayList<DrugData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend)

        init()
    }

    private fun init(){
        requestToServer.service.requestRecommend(
            RequestRecommend(8)
        ).customEnqueue(
            onError = { Log.e("server error","error")},
            onSuccess = {
                if(it.success){
                    data = it.data!!

                    val recommentAdapter = RecommendAdapter(supportFragmentManager, 2, data)
                    vp_home.run {
                        adapter = recommentAdapter
                        offscreenPageLimit = 1
                    }
                    tl_home.setupWithViewPager(vp_home)
                }
            }
        )

        txt_btn_buy.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("img",data[0].image)
            startActivity(intent)
        }

    }
}
