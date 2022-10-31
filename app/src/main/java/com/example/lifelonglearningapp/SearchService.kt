package com.example.lifelonglearningapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchService {
    @GET("tn_pubr_public_lftm_lrn_lctre_api")
    fun getEmgMedData(
        @Query("KEY") KEY: String,
        @Query("Type") Type: String
    ): Call<LifelongResponse>
}
