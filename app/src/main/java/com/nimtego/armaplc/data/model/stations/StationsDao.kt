package com.nimtego.armaplc.data.model.stations

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface StationsDao {

    @Transaction
    @Query("SELECT * FROM stations_table")
    fun getAll(): Flowable<List<StationModel>>

    @Transaction
    @Query("SELECT * FROM stations_table WHERE stationName LIKE :stationName")
    fun findByStationName(stationName: String): Flowable<StationModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg stationEntity: StationEntity): Completable

    @Query("DELETE from stations_table WHERE stationName IN (:name)")
    fun deleteByName(name: String): Completable

    @Delete
    fun delete(stationEntity: StationEntity): Completable

    @Update
    fun update(vararg stationEntity: StationEntity): Completable
}