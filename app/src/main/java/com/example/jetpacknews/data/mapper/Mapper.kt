package com.example.jetpacknews.data.mapper

import com.example.jetpacknews.common.utils.formatDateToHour
import com.example.jetpacknews.data.dto.response.ArticleDTO
import com.example.jetpacknews.domain.model.ArticleUiModel

fun ArticleDTO.toArticleUiModel(): ArticleUiModel {
    return ArticleUiModel(
        image = this.urlToImage ?: "",
        title = this.title ?: "",
        author = this.author ?: "",
        webUrl = this.url ?: "",
        description = this.description ?: "",
        source = when (this.source?.id) {
            "cnn" -> "https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/CNN_International_logo.svg/2048px-CNN_International_logo.svg.png"
            "reuters" -> "https://www.reuters.com/pf/resources/images/reuters/logo-vertical-default-512x512.png?d=163"
            "cbs-news" -> "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/CBS_News.svg/2560px-CBS_News.svg.png"
            "techcrunch" -> "https://cdn.icon-icons.com/icons2/2699/PNG/512/techcrunch_logo_icon_170625.png"
            else -> "https://play-lh.googleusercontent.com/Alt_6SesU0dU3YlDEsPREYkEb2ZMN-K4PMdLtUKO6ts1UBrDUF8Sh6LzcDYHd03jfP7z"
        },
        sourceName = this.source?.name ?: "",
        date = this.publishedAt?.formatDateToHour() ?: 0
    )
}

fun List<ArticleDTO>?.toArticleListUiModel() = this?.filter { it.title != "[Removed]" }?.map {
    it.toArticleUiModel()
} ?: emptyList()