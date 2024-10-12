package com.example.data.datasource

import com.example.data.dto.MaternityResponse
import com.example.data.service.MaternityService
import javax.inject.Inject

internal class MaternityDataSource @Inject constructor(
    private val maternityService: MaternityService
) {
    private val serviceKey = "BjQkoQuVF28dWdWRtQgCvXHvMpZC106xTTXTZz3sCXBzVkis/DbU246R4Fc4irqrvk2d+m9ujE6S/XONua+BWA=="
    suspend fun getMaternityInfo(): MaternityResponse {
        return maternityService.getMaternityInfo(
            page = 1,
            perPage = 10,
            serviceKey = serviceKey
        )
    }
}