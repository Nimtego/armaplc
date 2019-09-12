package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.domain.interactors.SaveStationInteractor
import com.nimtego.armaplc.domain.interactors.StationInteractor
import com.nimtego.armaplc.presentation.SchedulersProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule::class])
class DomainModule {

    @Provides
    @Singleton
    internal fun provideScheduler(): SchedulersProvider {
        return SchedulersProvider()
    }

    @Provides
    internal fun provideStationInteractor(
        stationRepository: StationRepository,
        schedulersProvider: SchedulersProvider
    ): StationInteractor {
        return StationInteractor(repository = stationRepository,
                                 schedulersProvider = schedulersProvider)
    }

    @Provides
    @Singleton
    internal fun provideSaveStationInteractor(
        stationRepository: StationRepository,
        schedulersProvider: SchedulersProvider
    ): SaveStationInteractor {
        return SaveStationInteractor(repository = stationRepository,
                                     schedulersProvider = schedulersProvider)
    }
}