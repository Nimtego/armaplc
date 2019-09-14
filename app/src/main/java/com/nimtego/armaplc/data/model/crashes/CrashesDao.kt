package com.nimtego.armaplc.data.model.crashes

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CrashesDao {

    @Query("SELECT * FROM crash_table")
    fun getAll(): Flowable<List<CrashEntity>>

    @Query("SELECT * FROM crash_table WHERE crash_type LIKE :crashType")
    fun findByCrashType(crashType: String): Flowable<List<CrashEntity>>

    @Query("SELECT * FROM crash_table WHERE station_name LIKE :stationId")
    fun findByPumpId(stationId: String): Flowable<List<CrashEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg crashEntities: CrashEntity): Completable

    @Delete
    fun delete(crashEntity: CrashEntity): Completable

    @Update
    fun update(vararg crashEntities: CrashEntity): Completable
}