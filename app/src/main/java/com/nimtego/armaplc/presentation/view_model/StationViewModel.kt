package com.nimtego.armaplc.presentation.view_model

import com.nimtego.armaplc.data.model.pump.PumpEntity

data class StationViewModel(val nameStation: String,
                            val phoneNumber: String,
                            val address: String,
                            val pumpModels: List<PumpEntity>?,
                            val requestInterval: Int,
                            val isPollActive: String)