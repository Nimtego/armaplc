package com.nimtego.armaplc.data.repository

import com.nimtego.armaplc.presentation.model.Station
import io.reactivex.Completable
import io.reactivex.Flowable

interface StationRepository {
    fun saveStation(station: Station): Completable
    fun getAllStations(): Flowable<List<Station>>
    fun getStationByName(name: String): Flowable<Station>
    fun removeStation(station: Station): Completable
}