package com.example.jetpacknews.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.components.CustomTopBar
import com.example.jetpacknews.ui.screen.home.components.TrendingItemNews

@Composable
fun TrendingScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        CustomTopBar(
            title = R.string.trending,
            modifier = Modifier.padding(horizontal = 16.dp),
            onClickNavigation = {
                navigateBack.invoke()
            })
        if (state.value.topNews.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(state.value.topNews) {
                    TrendingItemNews(articleUiModel = it)
                }
            }
        }
    }
}