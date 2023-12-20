package com.example.jetpacknews.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpacknews.ui.screen.auth.LoginScreen

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Screen.LoginScreen.route, route = Screen.AuthRoute.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen()
        }
    }
}