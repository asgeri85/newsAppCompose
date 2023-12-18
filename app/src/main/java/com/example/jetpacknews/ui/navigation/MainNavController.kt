package com.example.jetpacknews.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.jetpacknews.ui.screen.explore.ExploreScreen
import com.example.jetpacknews.ui.screen.home.HomeScreen
import com.example.jetpacknews.ui.screen.home.TrendingScreen
import com.example.jetpacknews.ui.screen.onboarding.OnboardingScreen
import com.example.jetpacknews.ui.screen.onboarding.SplashScreen
import com.example.jetpacknews.ui.theme.BlueF2

@Composable
fun MainNavController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navigateOnboarding = {
                navController.navigate(Screen.OnboardRoute.route) {
                    popUpTo(route = Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }, navigateHome = {
                navController.navigate(Screen.AppRoute.route) {
                    popUpTo(route = Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            })
        }
        onboardGraph(navController = navController)
        composable(route = Screen.AppRoute.route) {
            AppRouteScreen()
        }
    }
}
