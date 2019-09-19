package com.nimtego.armaplc.presentation.di

import android.app.Application
import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.storage.StationDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {


    @Provides
    @Singleton
    internal fun provideAppDataBase(application: Application): StationDatabase {
        return StationDatabase.invoke(application)
    }

    @Provides
    @Singleton
    internal fun provideMapper() = StationMapper()
}