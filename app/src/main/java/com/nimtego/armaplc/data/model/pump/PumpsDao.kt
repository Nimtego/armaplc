package com.nimtego.armaplc.data.model.pump

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface PumpsDao {

    @Query("SELECT * FROM pump_table")
    fun getAll(): Flowable<List<PumpEntity>>

    @Query("SELECT * FROM pump_table WHERE station_name LIKE :name")
    fun findByStationName(name: String): Flowable<List<PumpEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pumpEntity: PumpEntity): Completable

    @Delete
    fun delete(pumpEntity: PumpEntity): Completable

    @Update
    fun update(vararg pumpEntity: PumpEntity): Completable
}