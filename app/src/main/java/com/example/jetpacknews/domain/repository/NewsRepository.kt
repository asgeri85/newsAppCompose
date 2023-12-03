package com.example.jetpacknews.domain.repository

import com.example.jetpacknews.common.Resource
import com.example.jetpacknews.domain.model.ArticleUiModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getTopNews(country: String): Flow<Resource<List<ArticleUiModel>>>

}