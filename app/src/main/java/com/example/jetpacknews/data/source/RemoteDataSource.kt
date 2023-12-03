package com.example.jetpacknews.data.source

import com.example.jetpacknews.common.Resource
import com.example.jetpacknews.data.dto.response.ArticleDTO
import com.example.jetpacknews.data.dto.response.BaseResponse

interface RemoteDataSource {

    suspend fun getTopNews(country: String): Resource<BaseResponse<List<ArticleDTO>>>

}