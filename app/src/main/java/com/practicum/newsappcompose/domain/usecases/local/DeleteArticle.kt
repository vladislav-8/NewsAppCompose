package com.practicum.newsappcompose.domain.usecases.local

import com.practicum.newsappcompose.domain.models.Article
import com.practicum.newsappcompose.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(
        article: Article
    ) {
        newsRepository.deleteArticle(article)
    }
}