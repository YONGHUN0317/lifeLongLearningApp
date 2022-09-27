package com.example.lifelonglearningapp


import com.squareup.moshi.Json

data class Record(
    @Json(name = "강사명")
    val 강사명: String?,
    @Json(name = "강좌내용")
    val 강좌내용: String?,
    @Json(name = "강좌명")
    val 강좌명: String?,
    @Json(name = "강좌정원수")
    val 강좌정원수: String?,
    @Json(name = "교육대상구분")
    val 교육대상구분: String?,
    @Json(name = "교육방법구분")
    val 교육방법구분: String?,
    @Json(name = "교육시작시각")
    val 교육시작시각: String?,
    @Json(name = "교육시작일자")
    val 교육시작일자: String?,
    @Json(name = "교육장도로명주소")
    val 교육장도로명주소: String?,
    @Json(name = "교육장소")
    val 교육장소: String?,
    @Json(name = "교육종료시각")
    val 교육종료시각: String?,
    @Json(name = "교육종료일자")
    val 교육종료일자: String?,
    @Json(name = "데이터기준일자")
    val 데이터기준일자: String?,
    @Json(name = "선정방법구분")
    val 선정방법구분: String?,
    @Json(name = "수강료")
    val 수강료: String?,
    @Json(name = "운영기관명")
    val 운영기관명: String?,
    @Json(name = "운영기관전화번호")
    val 운영기관전화번호: String?,
    @Json(name = "운영요일")
    val 운영요일: String?,
    @Json(name = "접수방법구분")
    val 접수방법구분: String?,
    @Json(name = "접수시작일자")
    val 접수시작일자: String?,
    @Json(name = "접수종료일자")
    val 접수종료일자: String?,
    @Json(name = "제공기관명")
    val 제공기관명: String?,
    @Json(name = "제공기관코드")
    val 제공기관코드: String?,
    @Json(name = "직업능력개발훈련비지원강좌여부")
    val 직업능력개발훈련비지원강좌여부: String?,
    @Json(name = "평생학습계좌제평가인정여부")
    val 평생학습계좌제평가인정여부: String?,
    @Json(name = "학점은행제평가(학점)인정여부")
    val 학점은행제평가학점인정여부: String?,
    @Json(name = "홈페이지주소")
    val 홈페이지주소: String?
)