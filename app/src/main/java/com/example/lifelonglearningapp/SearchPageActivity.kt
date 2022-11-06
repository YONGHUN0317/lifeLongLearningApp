package com.example.lifelonglearningapp

import android.graphics.Color
import android.graphics.Color.BLACK
import android.telecom.Call
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import retrofit2.Callback
import com.example.lifelonglearningapp.databinding.ActivityMainBinding
import com.google.android.gms.common.api.Response
import kotlinx.android.synthetic.main.activity_aftersearch.*


class SearchPageActivity : AppCompatActivity() {


    private val binding: ActivityAftersearchBinding by lazy {
        ActivityAftersearchBinding.inflate(layoutInflater)
    }

    private val myRecyclerViewAdapter by lazy {
        SearchPageAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aftersearch)
        setContentView(binding.root)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = myRecyclerViewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        //retrofitWork()

    }



//    private fun retrofitWork() {
//        val service = RetrofitApi.searchService
//
//        service.getEmgMedData(getString(R.string.api_key), 0,20,"json")
//            .enqueue(object : Callback<LifelongResponse> {
//                override fun onResponse(
//                    call: retrofit2.Call<LifelongResponse>,
//                    response: retrofit2.Response<LifelongResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Log.d("Success", response?.body()?.response?.body?.items.toString())
//                        val result = response.body()?.response?.body?.items
//                        myRecyclerViewAdapter.submitList(result!!)
//                    }
//                }
//
//                override fun onFailure(call: retrofit2.Call<LifelongResponse>, t: Throwable) {
//                    Log.d("Failed", t.message.toString())
//                }
//
//            })
//    }




}