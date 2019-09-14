package com.nimtego.armaplc.data.model.stations

import androidx.room.Embedded
import androidx.room.Relation
import com.nimtego.armaplc.data.model.crashes.CrashEntity
import com.nimtego.armaplc.data.model.pump.PumpEntity

class StationModel() {
    @Embedded
    lateinit var stationEntity: StationEntity

    @Relation(parentColumn = "stationName", entityColumn = "station_name")
    var pumpsList: List<PumpEntity> = ArrayList()

    @Relation(parentColumn = "stationName", entityColumn = "station_name")
    var crashList: List<CrashEntity> = ArrayList()
}