package com.example.domain.repository

import com.example.domain.model.MaternityStores

interface MaternityRepository {
    suspend fun getMaternityInfo(): Result<MaternityStores>
}