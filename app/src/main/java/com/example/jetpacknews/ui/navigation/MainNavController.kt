package com.example.jetpacknews.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpacknews.ui.screen.explore.ExploreScreen
import com.example.jetpacknews.ui.screen.home.HomeScreen
import com.example.jetpacknews.ui.screen.home.TrendingScreen
import com.example.jetpacknews.ui.screen.onboarding.OnboardingScreen
import com.example.jetpacknews.ui.screen.onboarding.SplashScreen
import com.example.jetpacknews.ui.theme.BlueF2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavController() {

    val navController = rememberNavController()
    val showBottomBar = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomList = listOf(
        Screen.HomeScreen,
        Screen.ExploreScreen
    )

    showBottomBar.value = when (currentDestination?.route) {
        Screen.OnboardingScreen.route,
        Screen.SplashScreen.route,
        -> false

        else -> true
    }

    Scaffold(bottomBar = {
        if (showBottomBar.value) {
            BottomAppBar(
                containerColor = Color.White
            ) {
                bottomList.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon!!),
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(screen.name)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }, colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = BlueF2,
                            unselectedIconColor = Color.Black,
                            selectedTextColor = BlueF2,
                            unselectedTextColor = Color.Black,
                        )
                    )
                }
            }
        }
    }) {
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Screen.SplashScreen.route) {
                SplashScreen(navigateOnboarding = {
                    navController.navigate(Screen.OnboardingScreen.route)
                }, navigateHome = {
                    navController.navigate(Screen.HomeScreen.route)
                })
            }
            composable(route = Screen.OnboardingScreen.route) {
                OnboardingScreen()
            }
            composable(route = Screen.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = Screen.TrendingScreen.route) {
                TrendingScreen()
            }
            composable(route = Screen.ExploreScreen.route) {
                ExploreScreen()
            }
        }
    }
}
