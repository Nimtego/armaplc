package com.nimtego.armaplc.data.model.sms

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sms_command_table")
data class SmsCommandEntity(@PrimaryKey(autoGenerate = true)
                            var id: Long = 0,
                            @ColumnInfo(name = "sms_decrypted_message")
                            var decryptedMessage: String = "",
                            @ColumnInfo(name = "sms_encrypted_message")
                            var encryptedMessage: String = "",
                            @ColumnInfo(name = "sms_station_phone_number")
                            var phone: String,
                            @ColumnInfo(name = "sms_command_time")
                            var time: Long = 0)