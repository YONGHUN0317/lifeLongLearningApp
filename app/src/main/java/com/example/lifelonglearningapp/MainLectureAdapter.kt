package com.example.lifelonglearningapp

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lifelonglearningapp.fragments.*

class MainLectureAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int{
        return 14
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentSeoul()
            }
            1 -> {
                FragmentGyeonggi()
            }
            2 -> {
                FragmentIncheon()
            }
            3 -> {
                FragmentGangwon()
            }
            4 -> {
                FragmentChungcheong()
            }
            5 -> {
                FragmentSejong()
            }
            6 -> {
                FragmentDaejeon()
            }
            7 -> {
                FragmentGyeongsang()
            }
            8 -> {
                FragmentDaegu()
            }
            9 -> {
                FragmentBusan()
            }
            10 -> {
                FragmentUlsan()
            }
            11 -> {
                FragmentJeolla()
            }
            12 -> {
                FragmentGwanju()
            }
            13 -> {
                FragmentJeju()
            }else -> {Fragment()}



        }
    }

}