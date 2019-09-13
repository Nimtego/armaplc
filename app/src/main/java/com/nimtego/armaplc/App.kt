package com.nimtego.armaplc

import android.app.Application
import com.nimtego.armaplc.presentation.di.ApplicationComponent
import com.nimtego.armaplc.presentation.di.DaggerApplicationComponent

class App : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initAppComponent()
    }

    private fun initAppComponent() {
        this.appComponent =
            DaggerApplicationComponent
                .builder()
                .withApplication(this)
                .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }

    fun getAppComponent() = appComponent
}