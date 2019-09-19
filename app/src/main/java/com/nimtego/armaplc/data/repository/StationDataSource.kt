package com.nimtego.armaplc.data.repository

import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.data.storage.StationDatabase
import com.nimtego.armaplc.presentation.model.StationModel
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class StationDataSource @Inject constructor(
    stationDataBase: StationDatabase,
    private val stationMapper: StationMapper
) : StationRepository {

    private val stationDao = stationDataBase.stationDao()
    private val sensorDao = stationDataBase.sensorDao()

    override fun saveStation(station: StationModel): Completable {
        return this.stationDao.insertAll(this.stationMapper.stationToStationEntity(station))
    }

    override fun getAllStations(): Flowable<List<StationModel>> {
        return this.stationDao.getAll().map {
            it.map {stationEntity ->  this.stationMapper.toStationViewModel(stationEntity) }
        }
    }

    override fun getStationByName(name: String): Flowable<StationModel> {
        return this.stationDao.findByStationName(name).map {
            this.stationMapper.toStationViewModel(it)
        }
    }

    override fun removeStation(station: StationModel): Completable {
        return this.stationDao.delete(this.stationMapper.stationToStationEntity(station))
    }
}