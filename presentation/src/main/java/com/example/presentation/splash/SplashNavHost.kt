package com.example.presentation.login

import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.splash.SplashScreen
import androidx.navigation.compose.NavHost
import com.example.presentation.login.lock.LockScreen
import com.example.presentation.splash.SplashRoute

@Composable
fun SplashNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashRoute.SplashScreen
    ){
        composable(route = SplashRoute.SplashScreen.route){
            SplashScreen(
                navigateToLockScreen = {
                    navController.navigate(SplashRoute.LockScreen)
                },
                navigateToLoginScreen = {
                    navController.navigate(SplashRoute.LoginScreen)
                }
            )
        }
        composable(route = SplashRoute.LockScreen.route) {
            LockScreen()
        }
        composable(route = SplashRoute.LoginScreen.route){
            LoginScreen()
        }
    }
}