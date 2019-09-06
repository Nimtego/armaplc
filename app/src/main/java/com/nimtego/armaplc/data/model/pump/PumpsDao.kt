package com.nimtego.armaplc.data.model.pump

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nimtego.armaplc.data.model.pump.Pump

@Dao
interface PumpsDao {

    @Query("SELECT * FROM pump_table")
    fun getAll(): LiveData<List<Pump>>

    @Query("SELECT * FROM pump_table WHERE station_id LIKE :stationId")
    fun findByStationId(stationId: Long): Pump

    @Insert
    fun insertAll(vararg pump: Pump)

    @Delete
    fun delete(pump: Pump)

    @Update
    fun update(vararg pump: Pump)
}