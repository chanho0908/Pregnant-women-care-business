package com.example.presentation.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginState(
    val userNickName: String = "",
    val userEmail: String = "",
    val userProfileImage: String = "",
)