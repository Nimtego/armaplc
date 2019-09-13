package com.nimtego.armaplc.presentation.di

import android.app.Application
import android.content.Context
import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.storage.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {


    @Provides
    @Singleton
    internal fun provideAppDataBase(application: Application): AppDatabase {
        return AppDatabase.invoke(application)
    }

    @Provides
    @Singleton
    internal fun provideMapper() = StationMapper()
}