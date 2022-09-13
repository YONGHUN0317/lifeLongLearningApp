package com.example.lifelonglearningapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.lifecycle.Lifecycle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tablayout.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LifelongLearningApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainLectureAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter =adapter
        TabLayoutMediator(tabLayout, viewPager){ tab, position->
            when(position){
                0 ->{
                    
                }
            }}
    }

}