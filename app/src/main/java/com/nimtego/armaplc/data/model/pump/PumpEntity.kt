package com.nimtego.armaplc.data.model.pump

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pump_table")
data class PumpEntity(@PrimaryKey(autoGenerate = true)
                 var id: Long = 0,
                      @ColumnInfo(name = "station_name")
                 var stationName: String,
                      @ColumnInfo(name = "type_pump")
                 var typePump: String)