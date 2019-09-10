package com.nimtego.armaplc.data.repository

import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.storage.AppDatabase
import com.nimtego.armaplc.presentation.view_model.StationViewModel
import io.reactivex.Completable
import io.reactivex.Flowable

class DiskStationDataSource(
    appDataBase: AppDatabase,
    private val stationMapper: StationMapper
) : StationRepository {

    private val stationDao = appDataBase.stationDao()

    override fun saveStation(station: StationViewModel): Completable {
        return this.stationDao.insertAll(this.stationMapper.stationToStationEntity(station))
    }

    override fun getAllStations(): Flowable<List<StationViewModel>> {
        return this.stationDao.getAll().map {
            it.map {stationEntity ->  this.stationMapper.toStationViewModel(stationEntity) }
        }
    }

    override fun getStationByName(name: String): Flowable<StationViewModel> {
        return this.stationDao.findByStationName(name).map {
            this.stationMapper.toStationViewModel(it)
        }
    }

    override fun removeStation(station: StationViewModel): Completable {
        return this.stationDao.delete(this.stationMapper.stationToStationEntity(station))
    }
}