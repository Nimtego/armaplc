package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.repository.DiskStationDataSource
import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.data.storage.AppDatabase
import com.nimtego.armaplc.presentation.SchedulersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
class DataModule {

    @Provides
    @Singleton
    internal fun provideStationRepository(
        appDatabase: AppDatabase,
        mapper: StationMapper
    ): StationRepository {
        return DiskStationDataSource(appDatabase, mapper)
    }

    @Provides
    @Singleton
    internal fun provideMapper() = StationMapper()

}