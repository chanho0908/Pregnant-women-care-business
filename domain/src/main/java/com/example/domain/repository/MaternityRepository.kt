package com.example.domain.repository

import com.example.domain.model.MaternityStoreList

interface MaternityRepository {
    suspend fun getMaternityInfo(): Result<MaternityStoreList>
}