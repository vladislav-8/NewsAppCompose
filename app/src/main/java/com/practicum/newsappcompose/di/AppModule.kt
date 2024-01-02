package com.practicum.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.practicum.newsappcompose.data.impl.NewsRepositoryImpl
import com.practicum.newsappcompose.data.local.NewsDao
import com.practicum.newsappcompose.data.local.NewsDataBase
import com.practicum.newsappcompose.data.local.NewsTypeConverter
import com.practicum.newsappcompose.data.manager.LocalUserManagerImpl
import com.practicum.newsappcompose.data.remote.api.NewsApi
import com.practicum.newsappcompose.domain.manager.LocalUserManager
import com.practicum.newsappcompose.domain.repository.NewsRepository
import com.practicum.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.practicum.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.practicum.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import com.practicum.newsappcompose.domain.usecases.local.DeleteArticle
import com.practicum.newsappcompose.domain.usecases.local.SelectArticles
import com.practicum.newsappcompose.domain.usecases.local.UpsertArticle
import com.practicum.newsappcompose.domain.usecases.news.GetNews
import com.practicum.newsappcompose.domain.usecases.news.NewsUseCases
import com.practicum.newsappcompose.domain.usecases.news.SearchNews
import com.practicum.newsappcompose.util.Constants.BASE_URL
import com.practicum.newsappcompose.util.Constants.NEWS_DATABASE_NAME
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
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
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
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

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
            selectArticles = SelectArticles(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDataBase: NewsDataBase
    ): NewsDao = newsDataBase.newsDao
}