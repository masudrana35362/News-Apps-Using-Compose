package com.example.compose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.compose.data.remote.NewsApi
import com.example.compose.data.remote.NewsPagingSource
import com.example.compose.domain.model.Article
import com.example.compose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {

        return Pager(config = PagingConfig(pageSize = 10), pagingSourceFactory = {
            NewsPagingSource(
                newsApi = newsApi, sources = sources.joinToString(separator = ",")
            )
        }).flow

    }

}