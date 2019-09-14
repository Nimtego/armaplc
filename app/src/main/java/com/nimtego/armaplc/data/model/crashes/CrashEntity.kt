package com.nimtego.armaplc.data.model.crashes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crash_table")
data class CrashEntity(@PrimaryKey(autoGenerate = true)
                       var id: Long = 0,
                       @ColumnInfo(name = "crash_type")
                       var crashType: String,
                       @ColumnInfo(name = "station_name")
                       var stationName: String,
                       @ColumnInfo(name = "time")
                       var time: Long)