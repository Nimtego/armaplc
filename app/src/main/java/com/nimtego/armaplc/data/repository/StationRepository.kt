package com.nimtego.armaplc.data.repository

import com.nimtego.armaplc.presentation.view_model.StationViewModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface StationRepository {
    fun saveStation(station: StationViewModel): Completable
    fun getAllStations(): Flowable<List<StationViewModel>>
    fun getStationById(id: Long): Flowable<StationViewModel>
    fun removeStation(station: StationViewModel): Completable
}