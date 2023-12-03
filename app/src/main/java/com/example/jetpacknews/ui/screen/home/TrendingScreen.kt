package com.example.jetpacknews.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.components.CustomTopBar

@Composable
@Preview
fun TrendingScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Spacer(modifier = Modifier.height(24.dp))
        CustomTopBar(title = R.string.trending, modifier = Modifier.padding(horizontal = 16.dp))
    }
}