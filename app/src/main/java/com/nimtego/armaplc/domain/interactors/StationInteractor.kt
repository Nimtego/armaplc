package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.model.Station
import io.reactivex.Flowable
import javax.inject.Inject

class StationInteractor @Inject constructor(
    private val repository: StationRepository,
    private val schedulersProvider: SchedulersProvider
): FlowableInteractor<List<Station>, String?>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseFlowable(params: String?): Flowable<List<Station>> {
        return repository.getAllStations()
//        else repository.getStationByName(params)
    }

    private fun stationIsValid(stationVIew: Station): Boolean {
        return (stationVIew.nameStation.isNotBlank() &&
                stationVIew.phoneNumber.isNotBlank())
    }
}