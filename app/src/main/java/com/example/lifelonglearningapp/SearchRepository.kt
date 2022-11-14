package com.example.lifelonglearningapp

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: ApiService) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 40),
        pagingSourceFactory = { SearchPagingSource(apiService)
        }
    ).liveData
}