package com.nimtego.armaplc.presentation.view_model

import com.nimtego.armaplc.data.model.pump.PumpEntity

data class StationViewModel(val nameStation: String,
                            val phoneNumber: String,
                            val address: String = "",
                            val pumpCount: Int = 1,
                            val pumpModels: List<PumpEntity> = listOf(),
                            val requestInterval: Int = 0,
                            val isPollActive: String)