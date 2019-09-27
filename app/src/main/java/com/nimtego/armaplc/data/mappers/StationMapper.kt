package com.nimtego.armaplc.data.mappers

import com.nimtego.armaplc.data.model.stations.StationEntity
import com.nimtego.armaplc.data.model.stations.StationModelEntity
import com.nimtego.armaplc.presentation.model.Station

class StationMapper {
    fun stationToStationEntity(station: Station): StationEntity {
        return StationEntity(
            stationName = station.nameStation,
            stationPhoneNumber = station.phoneNumber,
            stationAddress = station.address,
            pollActiveState = station.isPollActive
        )
    }

    fun toStationViewModel(stations: StationModelEntity): Station {
        val stationEntity = stations.stationEntity
        val pumps = stations.pumpsList
        return Station(
            nameStation = stationEntity.stationName,
            phoneNumber = stationEntity.stationPhoneNumber,
            address = stationEntity.stationAddress,
            isPollActive = stationEntity.pollActiveState,
            pumpModels = pumps,
            requestInterval = stationEntity.stationRequestInterval
        )
    }
}