package com.nimtego.armaplc.data.model.stations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stations_table")
data class StationEntity(

    @PrimaryKey
    val stationName: String,

    @ColumnInfo(name = "state")
    val stationState: String = "",

    @ColumnInfo(name = "address")
    val stationAddress: String = "",

    @ColumnInfo(name = "count_request")
    val stationCountRequest: Int = 0,

    @ColumnInfo(name = "last_request_time")
    val stationLastRequestTime: Long = 0,

    @ColumnInfo(name = "last_response_time")
    val stationLastResponseTime: Long = 0,

    @ColumnInfo(name = "phone_number")
    val stationPhoneNumber: String,

    @ColumnInfo(name = "description")
    val stationDescription: String = "",

    @ColumnInfo(name = "request_interval")
    val stationRequestInterval: Int = 0
)

//val STATUS_CRASH = 2
//val STATUS_GOOD = 1
//val STATUS_UNDEFINED = 3
//private var _address: String? = null
//private var _brand: String? = null
//private var _doRequest: Int = 0
//private var _id: Long = 0
//private var _lastRequestTime: Long = 0
//private var _lastResponseTime: Long = 0
//private var _name: String? = null
//private var _phone: String? = null
//private var _pumpModels: ArrayList<PumpEntity>? = null
//private var _pumpsCount: Int = 0
//private var _requestInterval: Int = 0
//private var _sms_status: String? = null
//private var _state: StateData? = null
//private var _status: Int = 0
//private var _sw6pos: String? = null