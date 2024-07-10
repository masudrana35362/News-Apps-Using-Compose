package com.example.compose.data.remote.dto

import com.example.compose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)