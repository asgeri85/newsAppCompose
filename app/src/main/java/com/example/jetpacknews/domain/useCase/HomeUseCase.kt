package com.example.jetpacknews.domain.useCase

import com.example.jetpacknews.domain.repository.NewsRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    suspend fun getTopNews(country: String) = newsRepository.getTopNews(country)

}