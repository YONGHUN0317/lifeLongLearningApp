package com.example.lifelonglearningapp
import android.content.ClipData
import com.squareup.moshi.Json





data class LifelongResponse(
    @field:Json(name = "LifelongInfo")
    val LifelongInfo: List<LifelongInfo>?
)

data class LifelongInfo(
    val head: List<Head>?,
    val row: List<Row>?
)


data class Field(
    @field:Json(name = "id")
    val id: String?
)

data class Head(
    @field:Json(name = "api_version")
    val apiVersion: String?, // 1.0
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?, // 172
    @field:Json(name = "RESULT")
    val rESULT: RESULT?

)

data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?, // INFO-000
    @field:Json(name = "MESSAGE")
    val mESSAGE: String? // 정상 처리되었습니다.
)


data class Body(
    @field:Json(name = "items")
    val items: List<ClipData.Item?>?,
    @field:Json(name = "numOfRows")
    val numOfRows: String?,
    @field:Json(name = "pageNo")
    val pageNo: String?,
    @field:Json(name = "totalCount")
    val totalCount: String?
)



data class Row(
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

