package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.presentation.activity.AppActivity
import com.nimtego.armaplc.presentation.fragments.DashBoardFragment
import com.nimtego.armaplc.presentation.fragments.StationListFragment

import dagger.Component
import javax.inject.Singleton

//@Singleton
//@Component(modules = [PresenterModule::class,
//    SystemModule::class,
//    NavigationModule::class])
@Singleton
@Component(modules = [ContextModule::class])
interface ApplicationComponent {

    fun inject(activity: AppActivity)

    fun inject(fragment: DashBoardFragment)

    fun inject(fragment: StationListFragment)

}