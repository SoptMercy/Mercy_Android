package com.mercyteam.mercy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mercyteam.mercy.R

class RecommendFragment : Fragment() {

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

            }
            1 -> {

            }
            2 -> {

            }
            3 -> {

            }
        }

    }
}