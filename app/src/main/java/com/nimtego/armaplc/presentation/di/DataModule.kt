package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.repository.DiskStationDataSource
import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.data.storage.AppDatabase
import com.nimtego.armaplc.presentation.SchedulersProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideStationRepository(repository:  DiskStationDataSource): StationRepository


}