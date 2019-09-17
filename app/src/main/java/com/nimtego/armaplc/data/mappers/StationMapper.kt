package com.nimtego.armaplc.data.mappers

import com.nimtego.armaplc.data.model.stations.StationEntity
import com.nimtego.armaplc.data.model.stations.StationModelEntity
import com.nimtego.armaplc.presentation.model.StationModel

class StationMapper {
    fun stationToStationEntity(stationModel: StationModel): StationEntity {
        return StationEntity(
            stationName = stationModel.nameStation,
            stationPhoneNumber = stationModel.phoneNumber,
            stationAddress = stationModel.address
        )
    }

    fun toStationViewModel(stations: StationModelEntity): StationModel {
        val stationEntity = stations.stationEntity
        val pumps = stations.pumpsList
        return StationModel(
            nameStation = stationEntity.stationName,
            phoneNumber = stationEntity.stationPhoneNumber,
            address = stationEntity.stationAddress,
            isPollActive = stationEntity.stationState,
            pumpModels = pumps,
            requestInterval = stationEntity.stationRequestInterval
        )
    }
}