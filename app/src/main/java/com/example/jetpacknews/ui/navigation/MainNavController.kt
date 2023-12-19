package com.example.jetpacknews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpacknews.ui.screen.onboarding.OnboardingScreen
import com.example.jetpacknews.ui.screen.onboarding.SplashScreen

@Composable
fun MainNavController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navigateOnboarding = {
                navController.navigate(Screen.OnboardingScreen.route)
            }, navigateHome = {
                navController.navigate(Screen.AppRoute.route)
            })
        }
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingScreen(navigateHome = {
                navController.navigate(Screen.AppRoute.route)
            })
        }
        composable(route = Screen.AppRoute.route) {
            AppRouteScreen()
        }
    }
}
