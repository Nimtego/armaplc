package com.nimtego.armaplc.presentation.di

import com.nimtego.armaplc.presentation.activity.AppActivity
import com.nimtego.armaplc.presentation.fragments.DashBoardFragment
import com.nimtego.armaplc.presentation.fragments.StationListFragment

import dagger.Component
import javax.inject.Singleton
import android.app.Application
import com.nimtego.armaplc.presentation.fragments.AddStationFragment
import dagger.BindsInstance



//@Singleton
//@Component(modules = [PresenterModule::class,
//    SystemModule::class,
//    NavigationModule::class])
@Singleton
@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withApplication(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(stationListFragment: StationListFragment)
    fun inject(addStationFragment: AddStationFragment)


}