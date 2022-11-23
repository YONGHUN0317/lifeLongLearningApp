package com.example.lifelonglearningapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPageradapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val NUM_PAGES = 14

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainLecture.newInstance("page1", "adff", "cdff", "ddasf", "fasdf", "gafd")
            }
            1 -> {
                MainLecture.newInstance("page2", "a", "c", "d", "f", "g")
            }
            2 -> {
                MainLecture.newInstance("page3", "a", "c", "d", "f", "g")
            }
            3 -> {
                MainLecture.newInstance("page4", "a", "c", "d", "f", "g")
            }
            4 -> {
                MainLecture.newInstance("page5", "a", "c", "d", "f", "g")
            }
            5 -> {
                MainLecture.newInstance("page6", "a", "c", "d", "f", "g")
            }
            6 -> {
                MainLecture.newInstance("page7", "a", "c", "d", "f", "g")
            }
            7 -> {
                MainLecture.newInstance("page8", "a", "c", "d", "f", "g")
            }
            8 -> {
                MainLecture.newInstance("page9", "a", "c", "d", "f", "g")
            }
            9 -> {
                MainLecture.newInstance("page10", "a", "c", "d", "f", "g")
            }
            10 -> {
                MainLecture.newInstance("page11", "a", "c", "d", "f", "g")
            }
            11 -> {
                MainLecture.newInstance("page12", "a", "c", "d", "f", "g")
            }
            12 -> {
                MainLecture.newInstance("page13", "a", "c", "d", "f", "g")
            }
            else -> {
                MainLecture.newInstance("page14", "a", "c", "d", "f", "g")
            }
        }
    }

}