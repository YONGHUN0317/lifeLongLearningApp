package com.example.lifelonglearningapp


import com.squareup.moshi.Json

data class LifelongResponse(
    @Json(name = "fields")
    val fields: List<Field?>?,
    @Json(name = "records")
    val records: List<Record?>?
)