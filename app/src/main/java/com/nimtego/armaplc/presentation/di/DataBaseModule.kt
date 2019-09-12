package com.nimtego.armaplc.presentation.di

import android.content.Context
import com.nimtego.armaplc.data.storage.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ContextModule::class])
class DataBaseModule {

    @Provides
    @Singleton
    internal fun provideAppDataBase(context: Context): AppDatabase {
        return AppDatabase.invoke(context)
    }
}