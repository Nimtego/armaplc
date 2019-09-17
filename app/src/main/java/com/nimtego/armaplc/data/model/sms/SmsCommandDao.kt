package com.nimtego.armaplc.data.model.sms

import androidx.room.*
import com.nimtego.armaplc.data.model.pump.PumpEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface SmsCommandDao {

    @Query("SELECT * FROM sms_command_table")
    fun getAll(): Flowable<List<SmsCommandEntity>>

    @Query("SELECT * FROM sms_command_table WHERE sms_station_phone_number LIKE :phone")
    fun findByStationPhoneNumber(phone: String): Flowable<List<SmsCommandEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg smsCommand: SmsCommandEntity): Completable

    @Delete
    fun delete(smsCommand: SmsCommandEntity): Completable

    @Query("DELETE FROM sms_command_table WHERE id LIKE :smsCommandId")
    fun delete(smsCommandId: Long): Completable

    @Update
    fun update(vararg smsCommandId: SmsCommandEntity): Completable
}