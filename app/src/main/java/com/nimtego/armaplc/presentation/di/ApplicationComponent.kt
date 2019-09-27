package com.nimtego.armaplc.presentation.di

import android.app.Application
import com.nimtego.armaplc.presentation.ui.fragments.AddStationFragment
import com.nimtego.armaplc.presentation.ui.fragments.StationListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


//@Singleton
//@Component(modules = [PresenterModule::class,
//    SystemModule::class,
//    NavigationModule::class])
@Singleton
@Component(
    modules = [ViewModelModule::class,
               DomainModule::class,
               DataModule::class,
               DataBaseModule::class]
)
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