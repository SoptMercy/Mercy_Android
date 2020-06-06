package com.mercyteam.mercy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class RecommendAdapter(fm: FragmentManager, private val page_count: Int) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        val RecommendFragment = RecommendFragment()
        val bundle = Bundle(page_count)
        bundle.putInt("id",position)
        RecommendFragment.arguments = bundle
        return RecommendFragment
    }

    override fun getCount(): Int = page_count
}