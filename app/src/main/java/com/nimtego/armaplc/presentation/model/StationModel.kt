package com.nimtego.armaplc.presentation.model

import com.nimtego.armaplc.data.model.crashes.CrashEntity
import com.nimtego.armaplc.data.model.pump.PumpEntity
import com.nimtego.armaplc.data.model.sensors.SensorStateEntity

data class StationModel(val station: Station,
                        val pumpsList: List<PumpEntity>,
                        val crashList: List<CrashEntity>,
                        val sensorState: SensorStateEntity
)