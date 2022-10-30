package com.example.lifelonglearningapp

import android.graphics.Color
import android.graphics.Color.BLACK
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import com.example.lifelonglearningapp.databinding.ActivityMainBinding
import com.google.android.gms.common.api.Response
import retrofit2.Callback


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

        binding.aftersearchArrow.setOnClickListener{
            retrofitWork()
        }
    }
    private fun retrofitWork() {
        val service = RetrofitApi.searchService

        service.getEmgMedData(getString(R.string.api_key), "json")

            .enqueue(object : Callback<LifelongResponse>{
                override fun onResponse(
                    call: retrofit2.Call<LifelongResponse>,
                    response: retrofit2.Response<LifelongResponse>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: retrofit2.Call<LifelongResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            }
    }
}