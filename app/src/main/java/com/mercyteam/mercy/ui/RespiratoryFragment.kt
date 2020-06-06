package com.mercyteam.mercy.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.animation.AnimatorSetCompat.playTogether
import com.mercyteam.mercy.R
import kotlinx.android.synthetic.main.fragment_etc.*
import kotlinx.android.synthetic.main.fragment_respiratory.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RespiratoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RespiratoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_respiratory, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init(){
        cb_btn_respiratory_first.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) buttonView.setTextColor(Color.WHITE)
            else buttonView.setTextColor(resources.getColor(R.color.colorDarkBlack))
        }

        cb_btn_respiratory_second.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) buttonView.setTextColor(Color.WHITE)
            else buttonView.setTextColor(resources.getColor(R.color.colorDarkBlack))
        }

        cb_btn_respiratory_third.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) buttonView.setTextColor(Color.WHITE)
            else buttonView.setTextColor(resources.getColor(R.color.colorDarkBlack))
        }

        cb_btn_respiratory_fourth.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) buttonView.setTextColor(Color.WHITE)
            else buttonView.setTextColor(resources.getColor(R.color.colorDarkBlack))
        }

        cb_btn_respiratory_fifth.setOnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked) buttonView.setTextColor(Color.WHITE)
            else buttonView.setTextColor(resources.getColor(R.color.colorDarkBlack))
        }


        val fade = ObjectAnimator.ofFloat(cb_btn_respiratory_first,View.ALPHA,0.3f,1.0f)
        val fade2 = ObjectAnimator.ofFloat(cb_btn_respiratory_second,View.ALPHA,0.3f,1.0f)
        val fade3 = ObjectAnimator.ofFloat(cb_btn_respiratory_third,View.ALPHA,0.3f,1.0f)
        val fade4 = ObjectAnimator.ofFloat(cb_btn_respiratory_fourth,View.ALPHA,0.3f,1.0f)
        val fade5 = ObjectAnimator.ofFloat(cb_btn_respiratory_fifth,View.ALPHA,0.3f,1.0f)
        AnimatorSet().run {
            playTogether(fade,fade2,fade3,fade4,fade5)
            duration = 2000
            start()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RespiratoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RespiratoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}