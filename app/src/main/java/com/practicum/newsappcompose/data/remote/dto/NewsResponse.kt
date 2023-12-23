package com.practicum.newsappcompose.data.remote.dto

import com.practicum.newsappcompose.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)