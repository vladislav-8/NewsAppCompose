package com.practicum.newsappcompose.domain.usecases.news

import com.practicum.newsappcompose.domain.usecases.local.DeleteArticle
import com.practicum.newsappcompose.domain.usecases.local.SelectArticles
import com.practicum.newsappcompose.domain.usecases.local.UpsertArticle

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticles: SelectArticles
)