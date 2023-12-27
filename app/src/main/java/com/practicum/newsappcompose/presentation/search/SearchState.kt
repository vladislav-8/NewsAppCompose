package com.practicum.newsappcompose.presentation.search

import androidx.paging.PagingData
import com.practicum.newsappcompose.domain.models.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)