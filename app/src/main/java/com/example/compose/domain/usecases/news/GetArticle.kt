package com.example.compose.domain.usecases.news

import com.example.compose.data.local.NewsDao
import com.example.compose.domain.model.Article

class GetArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article? {
        return newsDao.getAticle(url)
    }

}