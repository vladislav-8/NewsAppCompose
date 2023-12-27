package com.practicum.newsappcompose.domain.repository

import androidx.paging.PagingData
import com.practicum.newsappcompose.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}