package com.example.data.di

import com.example.data.repository.MaternityRepositoryImpl
import com.example.domain.repository.MaternityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    fun bindMaternityRepository(maternityRepositoryImpl: MaternityRepositoryImpl): MaternityRepository
}