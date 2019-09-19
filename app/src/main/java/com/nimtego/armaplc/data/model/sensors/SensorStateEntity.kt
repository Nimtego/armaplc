package com.nimtego.armaplc.data.model.sensors

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sensor_table")
data class SensorStateEntity(@PrimaryKey(autoGenerate = true)
                       var id: Long = 0,
                             @ColumnInfo(name = "station_name")
                       var stationName: String,
                             @ColumnInfo(name = "sensor_level_state_1")
                       var sensorSensorState1: Boolean,
                             @ColumnInfo(name = "sensor_level_state_2")
                       var sensorSensorState2: Boolean,
                             @ColumnInfo(name = "sensor_level_state_3")
                       var sensorSensorState3: Boolean,
                             @ColumnInfo(name = "sensor_level_state_4")
                       var sensorSensorState4: Boolean)