package com.nimtego.armaplc.data.repository

import com.nimtego.armaplc.presentation.model.StationModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface StationRepository {
    fun saveStation(station: StationModel): Completable
    fun getAllStations(): Flowable<List<StationModel>>
    fun getStationByName(name: String): Flowable<StationModel>
    fun removeStation(station: StationModel): Completable
}