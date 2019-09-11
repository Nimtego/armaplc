package com.nimtego.armaplc.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(internal var context: Context) {

    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}