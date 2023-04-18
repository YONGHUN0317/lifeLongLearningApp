package yonghun.ksg.lifelonglearningapp

import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("tn_pubr_public_lftm_lrn_lctre_api")
    suspend fun getEmgMedData(
        @Query("serviceKey") KEY: String,
        @Query("pageNo") Page: Int,
        @Query("type") Type: String = "json",
    ): LifelongResponse
}
