package com.example.lifelonglearningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LifelongLearningApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}