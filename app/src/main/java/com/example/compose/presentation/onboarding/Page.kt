package com.example.compose.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.compose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Welcome to News Apps",
        description = "Get the latest news from around the world",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Breaking News",
        description = "Stay updated with the latest news",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "News Categories",
        description = "Explore news from different categories",
        image = R.drawable.onboarding3
    )
)
