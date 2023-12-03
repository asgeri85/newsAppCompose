package com.example.jetpacknews.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingUiModel(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)
