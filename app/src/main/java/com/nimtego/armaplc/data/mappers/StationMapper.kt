package com.nimtego.armaplc.data.mappers

import com.nimtego.armaplc.data.model.stations.StationEntity
import com.nimtego.armaplc.presentation.view_model.StationViewModel

class StationMapper {
    fun stationToStationEntity(stationViewModel: StationViewModel): StationEntity {
        return StationEntity(stationName = stationViewModel.nameStation,
                             stationPhoneNumber = stationViewModel.phoneNumber)
    }

    fun toStationViewModel(stations: StationEntity): StationViewModel {
        return StationViewModel(nameStation = stations.stationName,
                                phoneNumber = stations.stationPhoneNumber,
                                address = stations.stationAddress,
                                isPollActive = stations.stationState,
                                pumpModels = "",
                                requestInterval = 0)
    }
}