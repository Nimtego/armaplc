package com.nimtego.armaplc.presentation.view_model

import androidx.lifecycle.*
import com.nimtego.armaplc.domain.interactors.RemoveStationInteractor
import com.nimtego.armaplc.domain.interactors.StationInteractor
import com.nimtego.armaplc.presentation.model.Station
import com.nimtego.armaplc.presentation.model.StationsContainer
import javax.inject.Inject

class StationListViewModel @Inject constructor (
    private val interactor: StationInteractor,
    private val removeInteractor: RemoveStationInteractor
) : ViewModel(), LifecycleObserver {

    private val state: MutableLiveData<ViewState<StationsContainer>> = MutableLiveData()

    fun getState(): LiveData<ViewState<StationsContainer>> {
        return state
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadStation() {
        if (state.value == null) {
            state.postValue(ViewState(ViewState.Status.LOADING))
            interactor.execute(null,
                { listStation ->
                    val stationContainer = StationsContainer(listStation)
                    state.postValue(ViewState(ViewState.Status.SUCCESS, stationContainer))
                },
                { e ->
                    state.postValue(ViewState(ViewState.Status.ERROR, error = e))
                }
            )
        }
    }

    fun removeStation(station: Station) {
        this.removeInteractor.execute(station,
            { state.postValue(ViewState(ViewState.Status.SUCCESS)) },
            { state.postValue(ViewState(ViewState.Status.ERROR, error = it)) }
        )
    }


    override fun onCleared() {
        super.onCleared()
        interactor.dispose()
    }
}