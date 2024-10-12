package com.example.data.service

import com.example.data.dto.MaternityResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MaternityService {
    @GET("15129224/v1/uddi:8b7bae1c-1928-41cc-81dc-d63c7e72f667")
    suspend fun getMaternityInfo(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("serviceKey") serviceKey: String
    ): MaternityResponse
}