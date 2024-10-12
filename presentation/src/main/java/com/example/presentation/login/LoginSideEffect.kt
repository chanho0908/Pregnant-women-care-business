package com.example.presentation.login

sealed interface LoginSideEffect {
    data object Loading : LoginSideEffect
    data object Success : LoginSideEffect
    data class Failure(val message: String) : LoginSideEffect
}