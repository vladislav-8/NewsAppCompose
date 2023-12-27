package com.practicum.newsappcompose.domain.usecase.news

import androidx.paging.PagingData
import com.practicum.newsappcompose.domain.models.Article
import com.practicum.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(private val newsRepository: NewsRepository) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery, sources)
    }
}