package com.example.lifelonglearningapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPageradapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val NUM_PAGES = 14

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {MainLecture.newInstance("page1", "")}
            1 -> {MainLecture.newInstance("page2", "")}
            else -> {MainLecture.newInstance("page3", "")}
        }
    }
}