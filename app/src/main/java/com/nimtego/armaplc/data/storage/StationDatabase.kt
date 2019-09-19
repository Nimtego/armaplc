package com.nimtego.armaplc.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nimtego.armaplc.data.model.crashes.CrashEntity
import com.nimtego.armaplc.data.model.crashes.CrashesDao
import com.nimtego.armaplc.data.model.pump.PumpEntity
import com.nimtego.armaplc.data.model.pump.PumpsDao
import com.nimtego.armaplc.data.model.sensors.SensorStateDao
import com.nimtego.armaplc.data.model.sensors.SensorStateEntity
import com.nimtego.armaplc.data.model.stations.StationEntity
import com.nimtego.armaplc.data.model.stations.StationsDao

@Database(
    entities = [CrashEntity::class,
                PumpEntity::class,
                StationEntity::class,
                SensorStateEntity::class],
    version = 1, exportSchema = false
)
abstract class StationDatabase : RoomDatabase(){
    abstract fun crashesDao(): CrashesDao
    abstract fun pumpsDao(): PumpsDao
    abstract fun stationDao(): StationsDao
    abstract fun sensorDao(): SensorStateDao

    companion object {
        @Volatile private var instance: StationDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(
            LOCK
        ){
            instance
                ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            StationDatabase::class.java, "app_database.db")
            .build()
    }
}