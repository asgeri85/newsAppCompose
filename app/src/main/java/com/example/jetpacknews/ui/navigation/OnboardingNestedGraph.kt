package com.example.jetpacknews.ui.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpacknews.ui.screen.onboarding.OnboardingScreen

fun NavGraphBuilder.onboardGraph(navController: NavController){
    navigation(
        startDestination = Screen.OnboardingScreen.route,
        route = Screen.OnboardRoute.route
    ) {
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingScreen(navigateHome = {
                navController.navigate(Screen.AppRoute.route) {
                    popUpTo(route = Screen.OnboardRoute.route) {
                        inclusive = true
                    }
                }
            })
        }
    }
}