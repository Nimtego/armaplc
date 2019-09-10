package com.nimtego.armaplc.data.mappers

import com.nimtego.armaplc.data.model.stations.StationEntity
import com.nimtego.armaplc.data.model.stations.StationModel
import com.nimtego.armaplc.presentation.view_model.StationViewModel

class StationMapper {
    fun stationToStationEntity(stationViewModel: StationViewModel): StationEntity {
        return StationEntity(stationName = stationViewModel.nameStation,
                             stationPhoneNumber = stationViewModel.phoneNumber)
    }

    fun toStationViewModel(stations: StationModel): StationViewModel {
        val stationEntity = stations.stationEntity
        val pumps = stations.pumpsList
        return StationViewModel(nameStation = stationEntity.stationName,
                                phoneNumber = stationEntity.stationPhoneNumber,
                                address = stationEntity.stationAddress,
                                isPollActive = stationEntity.stationState,
                                pumpModels = pumps,
                                requestInterval = stationEntity.stationRequestInterval)
    }
}