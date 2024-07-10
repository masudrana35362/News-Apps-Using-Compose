package com.example.compose.domain.usecases.news

import androidx.paging.PagingData
import com.example.compose.domain.model.Article
import com.example.compose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }
}