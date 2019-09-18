package com.nimtego.armaplc.data.model.sensors

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SensorState(@PrimaryKey(autoGenerate = true)
                       var id: Long = 0,
                       @ColumnInfo(name = "station_name")
                       var stationName: String,
                       @ColumnInfo(name = "type_pump")
                       var typePump: String)