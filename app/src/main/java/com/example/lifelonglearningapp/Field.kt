package com.example.lifelonglearningapp


import com.squareup.moshi.Json

data class Field(
    @Json(name = "id")
    val id: String?
)