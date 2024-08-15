package com.example.compose.domain.usecases.news

import com.example.compose.data.local.NewsDao
import com.example.compose.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}