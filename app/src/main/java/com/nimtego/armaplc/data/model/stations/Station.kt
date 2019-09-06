package com.nimtego.armaplc.data.model.stations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stations_table")
data class Station(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "state")
    val state: String,

    @ColumnInfo(name = "station_name")
    val name: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "address")
    val countRequest: Int,

    @ColumnInfo(name = "last_request_time")
    val lastRequestTime: Long,

    @ColumnInfo(name = "last_response_time")
    val lastResponseTime: Long,

    @ColumnInfo(name = "list_pump_id")
    val pumps: List<Long>,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "request_interval")
    val requestInterval: Int
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
//private var _pumpModels: ArrayList<Pump>? = null
//private var _pumpsCount: Int = 0
//private var _requestInterval: Int = 0
//private var _sms_status: String? = null
//private var _state: StateData? = null
//private var _status: Int = 0
//private var _sw6pos: String? = null