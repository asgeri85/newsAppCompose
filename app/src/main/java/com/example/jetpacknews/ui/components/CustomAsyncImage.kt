package com.example.jetpacknews.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.jetpacknews.R

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    scale: ContentScale = ContentScale.None
) {
    AsyncImage(
        model = url,
        contentDescription = "image",
        placeholder = painterResource(id = R.drawable.placeholder_image),
        modifier = modifier,
        contentScale = scale,
        error = painterResource(id = R.drawable.placeholder_image)
    )
}