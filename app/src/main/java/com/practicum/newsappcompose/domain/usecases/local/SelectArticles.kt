package com.practicum.newsappcompose.domain.usecases.local

import com.practicum.newsappcompose.data.local.NewsDao
import com.practicum.newsappcompose.domain.models.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
       return newsDao.getArticles()
    }
}