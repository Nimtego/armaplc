package com.nimtego.armaplc.presentation.view_model

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nimtego.armaplc.domain.interactors.SaveStationInteractor
import com.nimtego.armaplc.presentation.model.Station
import javax.inject.Inject

class AddStationViewModel @Inject constructor(
    var saveStationInteractor: SaveStationInteractor
) : ViewModel(), LifecycleObserver {

    private val saveOperation: MutableLiveData<LiveEvent<ViewState<Unit>>> = MutableLiveData()

//    fun getState(): LiveData<ViewState<StationModelEntity>> {
//        return state
//    }

    fun saveStation(): LiveData<LiveEvent<ViewState<Unit>>> {
        return saveOperation
    }

    fun addStation(station: Station) {
        this.saveStationInteractor.execute(station,
            { saveOperation.postValue(LiveEvent(ViewState(ViewState.Status.SUCCESS))) },
            { saveOperation.postValue(LiveEvent(ViewState(ViewState.Status.ERROR, error = it))) }
        )
    }


    override fun onCleared() {
        super.onCleared()
        this.saveStationInteractor.dispose()
    }
}