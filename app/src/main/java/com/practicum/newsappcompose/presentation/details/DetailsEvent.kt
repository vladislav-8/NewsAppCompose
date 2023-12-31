package com.practicum.newsappcompose.presentation.details

sealed class DetailsEvent {

    data object SaveArticle: DetailsEvent()
}