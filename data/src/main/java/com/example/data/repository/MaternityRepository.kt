package com.example.data.repository

import com.example.data.datasource.MaternityDataSource
import com.example.domain.model.MaternityStores
import com.example.domain.repository.MaternityRepository
import javax.inject.Inject

internal class MaternityRepositoryImpl @Inject constructor(
    private val maternityDataSource: MaternityDataSource
): MaternityRepository {
    override suspend fun getMaternityInfo(): Result<MaternityStores> = runCatching{
        maternityDataSource.getMaternityInfo().toDomainModel()
    }
}