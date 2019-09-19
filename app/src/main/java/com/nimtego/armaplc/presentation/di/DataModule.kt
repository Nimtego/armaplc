package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.data.repository.StationDataSource
import com.nimtego.armaplc.data.repository.StationRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [DataBaseModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideStationRepository(repository:  StationDataSource): StationRepository


}