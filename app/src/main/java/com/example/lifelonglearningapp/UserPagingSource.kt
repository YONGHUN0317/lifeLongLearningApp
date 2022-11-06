package com.example.lifelonglearningapp

import android.provider.Settings.Secure.getString
import androidx.paging.PagingSource
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import retrofit2.Callback
import androidx.paging.PagingState

class UserPagingSource(
    private val service: SearchService,
) : PagingSource<Int, Items>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val page = params.key ?: 1
        return try {
            val response = service.getEmgMedData((R.string.api_key).toString(),page,20,"json")
            val user = response.response.body.items
            LoadResult.Page(
                data = user,
                prevKey = page % 2 -1,
                nextKey = page % 2 +1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}