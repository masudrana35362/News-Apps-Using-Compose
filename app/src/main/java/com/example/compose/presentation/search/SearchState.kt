package com.example.compose.presentation.search

import androidx.paging.PagingData
import com.example.compose.domain.model.Article
import kotlinx.coroutines.flow.Flow


data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null

) {
}