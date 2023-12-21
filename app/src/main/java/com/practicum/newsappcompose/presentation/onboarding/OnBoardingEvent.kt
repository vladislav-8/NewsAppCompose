package com.practicum.newsappcompose.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry: OnBoardingEvent()
}