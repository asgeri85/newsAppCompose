package com.example.jetpacknews.data.source

import com.example.jetpacknews.data.dto.response.ArticleDTO
import com.example.jetpacknews.data.dto.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopNews(@Query("country") country: String): Response<BaseResponse<List<ArticleDTO>>>

}