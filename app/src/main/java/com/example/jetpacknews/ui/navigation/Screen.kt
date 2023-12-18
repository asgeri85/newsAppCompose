package com.example.jetpacknews.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.jetpacknews.R

sealed class Screen(
    val route: String,
    @StringRes val name: Int,
    @DrawableRes val icon: Int? = null,
    val subScreenList: List<String> = emptyList()
) {

    //BottomBar Screen
    object HomeScreen :
        Screen("homeScreen", R.string.home, R.drawable.home, listOf("trendingScreen"))

    object ExploreScreen : Screen("exploreScreen", R.string.explore, R.drawable.compass)

    //Other Screen

    object OnboardingScreen : Screen("onboardingScreen", R.string.onboarding)

    object SplashScreen : Screen("splashScreen", R.string.splash)

    object TrendingScreen : Screen("trendingScreen", R.string.trending)

    object OnboardRoute : Screen("onboardingRoute", R.string.onboarding)

    object AppRoute : Screen("appRoute", R.string.home)

}