package com.nimtego.armaplc.data.model.stations

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface StationsDao {

    @Query("SELECT * FROM stations_table")
    fun getAll(): Flowable<List<StationEntity>>

    @Query("SELECT * FROM stations_table WHERE id LIKE :stationId")
    fun findByStationId(stationId: Long): Flowable<StationEntity>

    @Query("SELECT * FROM stations_table WHERE station_name LIKE :stationName")
    fun findByStationName(stationName: String): Flowable<StationEntity>

    @Insert
    fun insertAll(vararg stationEntity: StationEntity): Completable

    @Delete
    fun delete(stationEntity: StationEntity): Completable

    @Update
    fun update(vararg stationEntity: StationEntity): Completable
}