package com.example.jetpacknews.data.dto.response


import com.google.gson.annotations.SerializedName

data class SourceDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)