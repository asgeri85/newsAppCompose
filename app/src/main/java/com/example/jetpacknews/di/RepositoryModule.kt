package com.example.jetpacknews.di

import com.example.jetpacknews.data.repository.NewsRepositoryImpl
import com.example.jetpacknews.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepositoryModule(repositoryImpl: NewsRepositoryImpl): NewsRepository

}