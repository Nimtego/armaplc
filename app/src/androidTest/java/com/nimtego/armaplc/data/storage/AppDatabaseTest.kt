package com.nimtego.armaplc.data.storage

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.nimtego.armaplc.data.model.crashes.Crash
import com.nimtego.armaplc.data.model.crashes.CrashType
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.time.LocalDateTime
import java.util.*

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private lateinit var crashesDao: CrashesDao
    private lateinit var pumpsDao: PumpsDao
    private lateinit var appDataBase: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDataBase = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        crashesDao = appDataBase.crashesDao()
        pumpsDao = appDataBase.pumpsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        appDataBase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeCrushAndReadInList() {
        val crashType =  CrashType.CRASH_OVERHEATING
        val crash = Crash(crashType = crashType.name,
                                 pumpId = 2,
                                 time = LocalDateTime.now().second.toLong(),
                                 id = 0)
        crashesDao.insertAll(crash)
        val crashItem = crashesDao.findByCrashType(crashType.name).first()
        assertThat(crashItem.crashType, CoreMatchers.equalTo(crash.crashType))
    }
}