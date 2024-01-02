package com.practicum.newsappcompose.domain.usecases.local

import com.practicum.newsappcompose.data.local.NewsDao
import com.practicum.newsappcompose.domain.models.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(
        article: Article
    ) {
        newsDao.upsert(article)
    }
}