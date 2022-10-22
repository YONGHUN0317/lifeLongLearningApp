package com.example.lifelonglearningapp
import Item
import com.squareup.moshi.Json





data class LifelongResponse(
    @field:Json(name = "fields")
    val fields: List<Field?>?,
    @field:Json(name = "records")
    val records: List<Record?>?
)

data class Field(
    @field:Json(name = "id")
    val id: String?
)

data class Header(
    @field:Json(name = "resultCode")
    val resultCode: String?,
    @field:Json(name = "resultMsg")
    val resultMsg: String?,
    @field:Json(name = "type")
    val type: String?
)


data class Body(
    @field:Json(name = "items")
    val items: List<Item?>?,
    @field:Json(name = "numOfRows")
    val numOfRows: String?,
    @field:Json(name = "pageNo")
    val pageNo: String?,
    @field:Json(name = "totalCount")
    val totalCount: String?
)



data class Record(
    @field:Json(name = "edcColseTime")
    val edcColseTime: String?,
    @field:Json(name = "edcEndDay")
    val edcEndDay: String?,
    @field:Json(name = "edcMthType")
    val edcMthType: String?,
    @field:Json(name = "edcPlace")
    val edcPlace: String?,
    @field:Json(name = "edcRdnmadr")
    val edcRdnmadr: String?,
    @field:Json(name = "edcStartDay")
    val edcStartDay: String?,
    @field:Json(name = "edcStartTime")
    val edcStartTime: String?,
    @field:Json(name = "edcTrgetType")
    val edcTrgetType: String?,
    @field:Json(name = "homepageUrl")
    val homepageUrl: String?,
    @field:Json(name = "instrctrNm")
    val instrctrNm: String?,
    @field:Json(name = "insttCode")
    val insttCode: String?,
    @field:Json(name = "lctreCo")
    val lctreCo: String?,
    @field:Json(name = "lctreCost")
    val lctreCost: String?,
    @field:Json(name = "lctreNm")
    val lctreNm: String?,
    @field:Json(name = "lrnAcnutAckestYn")
    val lrnAcnutAckestYn: String?,
    @field:Json(name = "oadtCtLctreYn")
    val oadtCtLctreYn: String?,
    @field:Json(name = "operDay")
    val operDay: String?,
    @field:Json(name = "operInstitutionNm")
    val operInstitutionNm: String?,
    @field:Json(name = "operPhoneNumber")
    val operPhoneNumber: String?,
    @field:Json(name = "pntBankAckestYn")
    val pntBankAckestYn: String?,
    @field:Json(name = "psncpa")
    val psncpa: String?,
    @field:Json(name = "rceptEndDate")
    val rceptEndDate: String?,
    @field:Json(name = "rceptMthType")
    val rceptMthType: String?,
    @field:Json(name = "rceptStartDate")
    val rceptStartDate: String?,
    @field:Json(name = "referenceDate")
    val referenceDate: String?,
    @field:Json(name = "slctnMthType")
    val slctnMthType: String?
)

data class Response(
    @field:Json(name = "body")
    val body: Body?,
    @field:Json(name = "header")
    val header: Header?
)
