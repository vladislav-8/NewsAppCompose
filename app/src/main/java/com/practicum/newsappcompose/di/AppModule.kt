package com.practicum.newsappcompose.di

import android.app.Application
import com.practicum.newsappcompose.data.manager.LocalUserManagerImpl
import com.practicum.newsappcompose.domain.manager.LocalUserManager
import com.practicum.newsappcompose.domain.usecase.app_entry.AppEntryUseCases
import com.practicum.newsappcompose.domain.usecase.app_entry.ReadAppEntry
import com.practicum.newsappcompose.domain.usecase.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}