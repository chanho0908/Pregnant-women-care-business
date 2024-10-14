package com.example.data.dto

import com.example.domain.model.MaternityStore
import com.example.domain.model.MaternityStores
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MaternityResponse(
    val currentCount: Int,
    val data: List<Data>,
    val matchCount: Int,
    val page: Int,
    val perPage: Int,
    val totalCount: Int
) {
    fun toDomainModel(): MaternityStores {
        return MaternityStores(data.map {
            MaternityStore(
                longitude = it.경도,
                district = it.구,
                dataStandardDate = it.데이터기준일자,
                neighborhood = it.동,
                roadAddress = it.소재지도로명주소,
                lotAddress = it.소재지지번주소,
                storeName = it.업소명,
                storeType = it.업소종류,
                businessType = it.업종,
                latitude = it.위도,
                discountTarget = it.할인대상,
                discountRate = it.할인율 ?: "",
                discountItem = it.할인품목
            )
            }
        )
    }
}