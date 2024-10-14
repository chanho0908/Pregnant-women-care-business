package com.example.presentation.main

import androidx.compose.runtime.Immutable
import com.example.domain.model.MaternityStores

@Immutable
data class MainStates(
    val stores: List<MainState>
)

@Immutable
data class MainState(
    val storeName: String = "",
    val storeType: String = "",
    val businessType: String = "",
    val district: String = "",
    val neighborhood: String = "",
    val roadAddress: String = "",
    val lotAddress: String = "",
    val discountRate: String = "",
    val discountItem: String = "",
)

fun MaternityStores.toUiModel(): List<MainState> {
    return maternityStoreList.map {
        MainState(
            storeName = it.storeName,
            storeType = it.storeType,
            businessType = it.businessType,
            district = it.district,
            neighborhood = it.neighborhood,
            roadAddress = it.roadAddress,
            lotAddress = it.lotAddress,
            discountRate = it.discountRate,
            discountItem = it.discountItem
        )
    }
}
