package com.example.domain.usecase

import com.example.domain.model.MaternityStore
import com.example.domain.repository.MaternityRepository
import javax.inject.Inject

class GetMaternityStoreUseCase @Inject constructor(
    private val maternityRepository: MaternityRepository
) {
    suspend operator fun invoke(): Result<MaternityStore> {
        return maternityRepository.getMaternityInfo()
    }
}