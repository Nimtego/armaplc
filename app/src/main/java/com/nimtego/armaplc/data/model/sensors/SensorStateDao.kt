package com.nimtego.armaplc.data.model.sensors

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface SensorStateDao {

    @Query("SELECT * FROM sensor_table")
    fun getAll(): Flowable<List<SensorStateEntity>>

    @Query("SELECT * FROM sensor_table WHERE station_name LIKE :name")
    fun findByStationName(name: String): Flowable<List<SensorStateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg sensorStateEntity: SensorStateEntity): Completable

    @Delete
    fun delete(sensorStateEntity: SensorStateEntity): Completable

    @Update
    fun update(vararg sensorStateEntity: SensorStateEntity): Completable
}