package com.example.lifelonglearningapp
import android.content.ClipData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.google.gson.annotations.SerializedName

@JsonClass(generateAdapter = true)
data class LifelongResponse(
    @SerializedName("response")
    val response: Response?
)

@JsonClass(generateAdapter = true)
data class Response(
    @SerializedName("body")
    val body: Body?,
    @SerializedName("header")
    val header: Header?
)



//@JsonClass(generateAdapter = true)
//data class LifelongInfo(
//    val head: List<Header>?,
//    val row: List<Item>?
//)


@JsonClass(generateAdapter = true)
data class Header(
    @SerializedName("resultCode")
    val resultCode: String?,
    @SerializedName("resultMsg")
    val resultMsg: String?,
    @SerializedName("type")
    val type: String?
)

@JsonClass(generateAdapter = true)
data class Body(
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("numOfRows")
    val numOfRows: String?,
    @SerializedName("pageNo")
    val pageNo: String?,
    @SerializedName("totalCount")
    val totalCount: String?
)


@JsonClass(generateAdapter = true)
data class Item(
    @SerializedName("edcColseTime")
    val edcColseTime: String?,
    @SerializedName("edcEndDay")
    val edcEndDay: String?,
    @SerializedName("edcMthType")
    val edcMthType: String?,
    @SerializedName("edcPlace")
    val edcPlace: String?,
    @SerializedName("edcRdnmadr")
    val edcRdnmadr: String?,
    @SerializedName("edcStartDay")
    val edcStartDay: String?,
    @SerializedName("edcStartTime")
    val edcStartTime: String?,
    @SerializedName("edcTrgetType")
    val edcTrgetType: String?,
    @SerializedName("homepageUrl")
    val homepageUrl: String?,
    @SerializedName("instrctrNm")
    val instrctrNm: String?,
    @SerializedName("insttCode")
    val insttCode: String?,
    @SerializedName("lctreCo")
    val lctreCo: String?,
    @SerializedName("lctreCost")
    val lctreCost: String?,
    @SerializedName("lctreNm")
    val lctreNm: String?,
    @SerializedName("lrnAcnutAckestYn")
    val lrnAcnutAckestYn: String?,
    @SerializedName("oadtCtLctreYn")
    val oadtCtLctreYn: String?,
    @SerializedName("operDay")
    val operDay: String?,
    @SerializedName("operInstitutionNm")
    val operInstitutionNm: String?,
    @SerializedName("operPhoneNumber")
    val operPhoneNumber: String?,
    @SerializedName("pntBankAckestYn")
    val pntBankAckestYn: String?,
    @SerializedName("psncpa")
    val psncpa: String?,
    @SerializedName("rceptEndDate")
    val rceptEndDate: String?,
    @SerializedName("rceptMthType")
    val rceptMthType: String?,
    @SerializedName("rceptStartDate")
    val rceptStartDate: String?,
    @SerializedName("referenceDate")
    val referenceDate: String?,
    @SerializedName("slctnMthType")
    val slctnMthType: String?
)

