package com.practicum.newsappcompose.presentation.bookmark

import com.practicum.newsappcompose.domain.models.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)