package com.example.jetpacknews.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.jetpacknews.ui.screen.explore.ExploreScreen
import com.example.jetpacknews.ui.screen.home.HomeScreen
import com.example.jetpacknews.ui.screen.home.TrendingScreen
import com.example.jetpacknews.ui.theme.BlueF2

@Composable
fun AppRouteScreen() {

    val navController = rememberNavController()

    val bottomList = listOf(
        Screen.HomeScreen,
        Screen.ExploreScreen
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Scaffold(bottomBar = {
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
    }) {
        NavHost(
            navController = navController,
            startDestination = Screen.AppRoute.route,
            modifier = Modifier.padding(it)
        ) {
            navigation(startDestination = Screen.HomeScreen.route, route = Screen.AppRoute.route) {
                composable(route = Screen.HomeScreen.route) {
                    HomeScreen(navigateTrend = {
                        navController.navigate(Screen.TrendingScreen.route)
                    })
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
}