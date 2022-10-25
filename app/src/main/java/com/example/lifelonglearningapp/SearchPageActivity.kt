package com.example.lifelonglearningapp

import android.graphics.Color
import android.graphics.Color.BLACK
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import com.example.lifelonglearningapp.databinding.ActivityMainBinding


class SearchPageActivity : AppCompatActivity() {

    private val binding : ActivityAftersearchBinding by lazy {
        ActivityAftersearchBinding.inflate(layoutInflater)
    }

    private val myRecyclerViewAdapter by lazy {
        SearchPageAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = myRecyclerViewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

    }
}