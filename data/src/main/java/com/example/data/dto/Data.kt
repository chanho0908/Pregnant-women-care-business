package com.example.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val 경도: String,
    val 구: String,
    val 데이터기준일자: String,
    val 동: String,
    val 소재지도로명주소: String,
    val 소재지지번주소: String,
    val 업소명: String,
    val 업소종류: String,
    val 업종: String,
    val 위도: String,
    val 할인대상: String,
    val 할인율: String?,
    val 할인품목: String
)