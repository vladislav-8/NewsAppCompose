package com.practicum.newsappcompose.di

import android.app.Application
import com.practicum.newsappcompose.data.impl.NewsRepositoryImpl
import com.practicum.newsappcompose.data.manager.LocalUserManagerImpl
import com.practicum.newsappcompose.data.remote.api.NewsApi
import com.practicum.newsappcompose.domain.manager.LocalUserManager
import com.practicum.newsappcompose.domain.repository.NewsRepository
import com.practicum.newsappcompose.domain.usecase.app_entry.AppEntryUseCases
import com.practicum.newsappcompose.domain.usecase.app_entry.ReadAppEntry
import com.practicum.newsappcompose.domain.usecase.app_entry.SaveAppEntry
import com.practicum.newsappcompose.domain.usecase.news.GetNews
import com.practicum.newsappcompose.domain.usecase.news.NewsUseCases
import com.practicum.newsappcompose.util.Constants.BASE_URL
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
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}