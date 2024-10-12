package com.example.domain.model

data class MaternityStore(
    val longitude: String,
    val district: String,
    val dataStandardDate: String,
    val neighborhood: String,
    val roadAddress: String,
    val lotAddress: String,
    val storeName: String,
    val storeType: String,
    val businessType: String,
    val latitude: String,
    val discountTarget: String,
    val discountRate: String,
    val discountItem: String
)

data class MaternityStoreList(
    val maternityStoreList: List<MaternityStore>
)