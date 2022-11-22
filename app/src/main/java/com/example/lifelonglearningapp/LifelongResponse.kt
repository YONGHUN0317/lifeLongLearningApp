package com.example.lifelonglearningapp

import android.content.ClipData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Url


@JsonClass(generateAdapter = true)
data class LifelongResponse(
    @Expose
    @SerializedName("response")
    var response: Response,

    )

@JsonClass(generateAdapter = true)
data class Response(
    @Expose
    @SerializedName("header")
    var header: Header,
    @Expose
    @SerializedName("body")
    var body: Body
)


@JsonClass(generateAdapter = true)
data class Body(
    @Expose
    @SerializedName("items")
    var items: List<Items>,
    @Expose
    @SerializedName("totalCount")
    val totalCount: String,
    @Expose
    @SerializedName("numOfRows")
    val numOfRows: String,
    @Expose
    @SerializedName("pageNo")
    val pageNo: String,
)

@JsonClass(generateAdapter = true)
data class Items(
    @Expose
    @SerializedName("lctreNm")
    val lctreNm: String,
    @Expose
    @SerializedName("instrctrNm")
    val instrctrNm: String,
    @Expose
    @SerializedName("edcStartDay")
    val edcStartDay: String,
    @Expose
    @SerializedName("edcEndDay")
    val edcEndDay: String,
    @Expose
    @SerializedName("edcStartTime")
    val edcStartTime: String,
    @Expose
    @SerializedName("edcColseTime")
    val edcColseTime: String,
    @Expose
    @SerializedName("lctreCo")
    val lctreCo: String,
    @Expose
    @SerializedName("edcTrgetType")
    val edcTrgetType: String,
    @Expose
    @SerializedName("edcMthType")
    val edcMthType: String,
    @Expose
    @SerializedName("operDay")
    val operDay: String,
    @Expose
    @SerializedName("edcPlace")
    val edcPlace: String,
    @Expose
    @SerializedName("psncpa")
    val psncpa: String,
    @Expose
    @SerializedName("lctreCost")
    val lctreCost: String,
    @Expose
    @SerializedName("edcRdnmadr")
    val edcRdnmadr: String,
    @Expose
    @SerializedName("operInstitutionNm")
    val operInstitutionNm: String,
    @Expose
    @SerializedName("operPhoneNumber")
    val operPhoneNumber: String,
    @Expose
    @SerializedName("rceptStartDate")
    val rceptStartDate: String,
    @Expose
    @SerializedName("rceptEndDate")
    val rceptEndDate: String,
    @Expose
    @SerializedName("rceptMthType")
    val rceptMthType: String,
    @Expose
    @SerializedName("slctnMthType")
    val slctnMthType: String,
    @Expose
    @SerializedName("homepageUrl")
    val homepageUrl: String,
    @Expose
    @SerializedName("oadtCtLctreYn")
    val oadtCtLctreYn: String,
    @Expose
    @SerializedName("pntBankAckestYn")
    val pntBankAckestYn: String,
    @Expose
    @SerializedName("lrnAcnutAckestYn")
    val lrnAcnutAckestYn: String,
    @Expose
    @SerializedName("referenceDate")
    val referenceDate: String,
    @Expose
    @SerializedName("insttCode")
    val insttCode: String
)

@JsonClass(generateAdapter = true)
data class Header(
    @Expose
    @SerializedName("resultCode")
    val resultCode: String,
    @Expose
    @SerializedName("resultMsg")
    val resultMsg: String,
    @Expose
    @SerializedName("type")
    val type: String
)
