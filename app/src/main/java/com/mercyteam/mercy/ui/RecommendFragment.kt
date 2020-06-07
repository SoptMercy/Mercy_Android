package com.mercyteam.mercy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mercyteam.mercy.R
import com.mercyteam.mercy.data.DrugData
import kotlinx.android.synthetic.main.fragment_recommend.*

class RecommendFragment(private val data: ArrayList<DrugData>) : Fragment() {

    var view_id = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view_id = arguments!!.getInt("id")
        init()
    }

    private fun init(){
        when(view_id){
            0 -> {
                Glide.with(context!!).load(data[0].image).into(img_logo)
                tv_name.text = data[0].name
                tv_price.text = data[0].price.substring(0,1)+","+data[0].price.substring(1,4)
                tv_detail.text = data[0].content
            }
            1 -> {
                Glide.with(context!!).load(data[1].image).into(img_logo)
                tv_name.text = data[1].name
                tv_price.text = data[1].price.substring(0,1)+","+data[0].price.substring(1,4)
                tv_detail.text = data[1].content
            }
        }

    }
}