package com.nimtego.armaplc.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nimtego.armaplc.presentation.view_model.AddStationViewModel
import com.nimtego.armaplc.presentation.view_model.AppViewModelFactory
import com.nimtego.armaplc.presentation.view_model.StationListViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StationListViewModel::class)
    abstract fun stationListViewModel(stationListViewModel: StationListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddStationViewModel::class)
    abstract fun addStationViewModel(groupViewModel: AddStationViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}