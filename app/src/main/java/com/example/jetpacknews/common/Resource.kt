package com.example.jetpacknews.common

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val result: T?) : Resource<T>()
    data class Error(val throwable: Exception) : Resource<Nothing>()
}