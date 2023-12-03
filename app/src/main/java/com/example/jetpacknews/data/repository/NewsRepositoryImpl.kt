package com.example.jetpacknews.data.repository

import com.example.jetpacknews.common.Resource
import com.example.jetpacknews.data.mapper.toArticleListUiModel
import com.example.jetpacknews.data.mapper.toArticleUiModel
import com.example.jetpacknews.data.source.RemoteDataSource
import com.example.jetpacknews.domain.model.ArticleUiModel
import com.example.jetpacknews.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : NewsRepository {

    override suspend fun getTopNews(country: String): Flow<Resource<List<ArticleUiModel>>> = flow {
        emit(Resource.Loading)
        when (val response = remoteDataSource.getTopNews(country)) {
            is Resource.Success -> emit(Resource.Success(response.result?.articles?.toArticleListUiModel()))
            is Resource.Error -> emit(Resource.Error(response.throwable))
            else -> {}
        }
    }.flowOn(Dispatchers.IO)
}