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
            2 -> {MainLecture.newInstance("page3", "")}
            3 -> {MainLecture.newInstance("page4", "")}
            4 -> {MainLecture.newInstance("page5", "")}
            5 -> {MainLecture.newInstance("page6", "")}
            6 -> {MainLecture.newInstance("page7", "")}
            7 -> {MainLecture.newInstance("page8", "")}
            8 -> {MainLecture.newInstance("page9", "")}
            9 -> {MainLecture.newInstance("page10", "")}
            10 -> {MainLecture.newInstance("page11", "")}
            11 -> {MainLecture.newInstance("page12", "")}
            12 -> {MainLecture.newInstance("page13", "")}
            else -> {MainLecture.newInstance("page14", "")}
        }
    }
}