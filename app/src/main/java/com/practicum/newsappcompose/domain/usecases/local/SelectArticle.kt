package com.practicum.newsappcompose.domain.usecases.local

import com.practicum.newsappcompose.domain.models.Article
import com.practicum.newsappcompose.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(
        url: String
    ): Article? {
        return newsRepository.selectArticle(url)
    }
}