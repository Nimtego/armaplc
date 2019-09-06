package com.nimtego.armaplc.data.model.pump

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pump_table")
data class Pump(@PrimaryKey(autoGenerate = true)
                 var id: Long = 0,
                 @ColumnInfo(name = "station_id")
                 var stationId: Long,
                 @ColumnInfo(name = "time")
                 var name: String)