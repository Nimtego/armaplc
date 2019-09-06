package com.nimtego.armaplc.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nimtego.armaplc.data.model.crashes.Crash
import com.nimtego.armaplc.data.model.crashes.CrashesDao
import com.nimtego.armaplc.data.model.pump.Pump
import com.nimtego.armaplc.data.model.pump.PumpsDao

@Database(
    entities = [Crash::class, Pump::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun crashesDao(): CrashesDao
    abstract fun pumpsDao(): PumpsDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(
            LOCK
        ){
            instance
                ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "app_database.db")
            .build()
    }
}