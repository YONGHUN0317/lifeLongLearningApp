package com.example.lifelonglearningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    lateinit var quoteViewModel: SearchViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SearchPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aftersearch)


        recyclerView = findViewById(R.id.recyclerView)

        quoteViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        adapter = SearchPagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })
    }
}