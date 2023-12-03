package com.example.jetpacknews.domain.model

data class ArticleUiModel(
    val image: String,
    val title: String,
    val author: String,
    val webUrl: String,
    val description: String,
    val source: String,
    val sourceName: String,
    val date: Int
)
