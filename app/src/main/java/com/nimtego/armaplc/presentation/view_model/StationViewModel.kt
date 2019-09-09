package com.nimtego.armaplc.presentation.view_model

data class StationViewModel(val nameStation: String,
                            val phoneNumber: String,
                            val address: String,
                            val pumpModels: String,
                            val requestInterval: Int,
                            val isPollActive: String)