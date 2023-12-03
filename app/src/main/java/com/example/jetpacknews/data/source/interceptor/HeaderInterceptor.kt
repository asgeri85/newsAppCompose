package com.example.jetpacknews.data.source.interceptor

import com.example.jetpacknews.common.Constants.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("X-Api-Key", API_KEY)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}