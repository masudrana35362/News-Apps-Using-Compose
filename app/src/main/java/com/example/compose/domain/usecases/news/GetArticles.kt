package com.example.compose.domain.usecases.news

import com.example.compose.data.local.NewsDao
import com.example.compose.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }
}