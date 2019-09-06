package com.nimtego.armaplc.data.model.crashes

import androidx.room.*
import com.nimtego.armaplc.data.model.crashes.Crash

@Dao
interface CrashesDao {

    @Query("SELECT * FROM crash_table")
    fun getAll(): List<Crash>

    @Query("SELECT * FROM crash_table WHERE crash_type LIKE :crashType")
    fun findByCrashType(crashType: String): List<Crash>

    @Query("SELECT * FROM crash_table WHERE pump_id LIKE :pumpId")
    fun findByPumpId(pumpId: Long): List<Crash>

    @Insert
    fun insertAll(vararg crash: Crash)

    @Delete
    fun delete(crash: Crash)

    @Update
    fun update(vararg crash: Crash)
}