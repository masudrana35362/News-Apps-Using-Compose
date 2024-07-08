package com.example.compose.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry: OnBoardingEvent()
}