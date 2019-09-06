package com.nimtego.armaplc.data.model.crashes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crash_table")
data class Crash(@PrimaryKey(autoGenerate = true)
                 var id: Long,
                 @ColumnInfo(name = "crash_type")
                 var crashType: String,
                 @ColumnInfo(name = "pump_id")
                 var pumpId: Long,
                 @ColumnInfo(name = "time")
                 var time: Long)