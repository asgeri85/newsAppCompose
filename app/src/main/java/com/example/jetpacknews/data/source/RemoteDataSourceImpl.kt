package com.example.jetpacknews.data.source

import com.example.jetpacknews.common.Resource
import com.example.jetpacknews.common.error.NetworkError
import com.example.jetpacknews.data.dto.response.ArticleDTO
import com.example.jetpacknews.data.dto.response.BaseResponse
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: NewsService,
    private val gson: Gson
) : RemoteDataSource {
    override suspend fun getTopNews(country: String): Resource<BaseResponse<List<ArticleDTO>>> =
        handleResponse {
            api.getTopNews(country)
        }

    private suspend fun <T> handleResponse(responseLambda: suspend () -> Response<T>): Resource<T> {
        try {
            val response = responseLambda.invoke()

            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            val error: NetworkError =
                gson.fromJson(
                    response.errorBody()?.charStream(),
                    NetworkError::class.java
                )
            throw Exception(error)

        } catch (e: Exception) {
            return Resource.Error(e)
        }

    }
}