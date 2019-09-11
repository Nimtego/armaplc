package com.nimtego.armaplc.presentation.view_model

import androidx.lifecycle.*
import com.nimtego.armaplc.data.mappers.StationMapper
import com.nimtego.armaplc.domain.interactors.SaveStationInteractor
import com.nimtego.armaplc.domain.interactors.StationInteractor
import com.nimtego.armaplc.presentation.model.StationsContainer
import javax.inject.Inject

class AddStationViewModel @Inject constructor(
    val saveStationInteractor: SaveStationInteractor
) : ViewModel(), LifecycleObserver {

    private val saveOperation: MutableLiveData<LiveEvent<ViewState<Unit>>> = MutableLiveData()

//    fun getState(): LiveData<ViewState<StationViewModel>> {
//        return state
//    }

    fun saveStation(): LiveData<LiveEvent<ViewState<Unit>>> {
        return saveOperation
    }
    fun addStation(station: StationViewModel) {
        this.saveStationInteractor.execute(station,
            {
                saveOperation.postValue(LiveEvent(ViewState(ViewState.Status.SUCCESS)))
            },
            {
                saveOperation.postValue(LiveEvent(ViewState(ViewState.Status.ERROR, error = it)))
            }
        )
    }


    override fun onCleared() {
        super.onCleared()
        this.saveStationInteractor.dispose()
    }
}