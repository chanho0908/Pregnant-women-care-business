package com.example.presentation.splash

sealed class SplashRoute(val route: String) {
    object SplashScreen : SplashRoute("SplashScreen")
    object LockScreen : SplashRoute("LockScreen")
    object LoginScreen : SplashRoute("LoginScreen")
}