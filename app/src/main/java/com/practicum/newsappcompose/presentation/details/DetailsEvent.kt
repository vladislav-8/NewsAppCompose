package com.practicum.newsappcompose.presentation.details

import com.practicum.newsappcompose.domain.models.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(
        val article: Article
    ): DetailsEvent()

    data object RemoveSideEffect: DetailsEvent()
}