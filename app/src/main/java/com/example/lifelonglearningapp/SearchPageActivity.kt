package com.example.lifelonglearningapp

import android.graphics.Color
import android.graphics.Color.BLACK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import com.example.lifelonglearningapp.databinding.ActivityMainBinding


class SearchPageActivity : AppCompatActivity()  {

    private lateinit var binding:  ActivityAftersearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAftersearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}