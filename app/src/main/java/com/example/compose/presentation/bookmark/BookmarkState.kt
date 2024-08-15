package com.example.compose.presentation.bookmark

import com.example.compose.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
) {
}