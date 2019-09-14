package com.nimtego.armaplc.presentation.view_model

import androidx.lifecycle.*
import com.nimtego.armaplc.domain.interactors.StationInteractor
import com.nimtego.armaplc.presentation.model.StationsContainer
import javax.inject.Inject

class StationListViewModel @Inject constructor (
    val interactor: StationInteractor
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


    override fun onCleared() {
        super.onCleared()
        interactor.dispose()
    }
}