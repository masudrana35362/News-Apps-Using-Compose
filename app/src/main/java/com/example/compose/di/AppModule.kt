package com.example.compose.di

import android.app.Application
import androidx.room.Room
import com.example.compose.data.local.NewsDao
import com.example.compose.data.local.NewsDatabase
import com.example.compose.data.local.NewsTypeConverter
import com.example.compose.data.manager.LocalUserManagerImpl
import com.example.compose.data.remote.NewsApi
import com.example.compose.data.repository.NewsRepositoryImpl
import com.example.compose.domain.manager.LocalUserManager
import com.example.compose.domain.repository.NewsRepository
import com.example.compose.domain.usecases.app_entry.AppEntryUseCases
import com.example.compose.domain.usecases.app_entry.ReadAppEntry
import com.example.compose.domain.usecases.app_entry.SaveAppEntry
import com.example.compose.domain.usecases.news.DeleteArticle
import com.example.compose.domain.usecases.news.GetArticle
import com.example.compose.domain.usecases.news.GetNews
import com.example.compose.domain.usecases.news.NewsUseCases
import com.example.compose.domain.usecases.news.SearchNews
import com.example.compose.domain.usecases.news.GetArticles
import com.example.compose.domain.usecases.news.UpsertArticle
import com.example.compose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),
            getArticle = GetArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}