package com.example.lifelonglearningapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchService {
    @GET("LifelongInfo")
    fun getEmgMedData(
        @Query("KEY") KEY: String,
        @Query("Type") Type: String
    ): Call<LifelongResponse>
}
