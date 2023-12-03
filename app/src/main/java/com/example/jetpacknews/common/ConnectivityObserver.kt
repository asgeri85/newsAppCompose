package com.example.jetpacknews.common

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    enum class InternetStatus { AVAILABLE, UNAVAILABLE,LOST }

    fun observe(): Flow<InternetStatus>
}