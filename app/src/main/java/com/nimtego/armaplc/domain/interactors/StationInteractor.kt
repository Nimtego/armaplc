package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.model.StationModel
import io.reactivex.Flowable
import javax.inject.Inject

class StationInteractor @Inject constructor(
    private val repository: StationRepository,
    private val schedulersProvider: SchedulersProvider
): FlowableInteractor<List<StationModel>, String?>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseFlowable(params: String?): Flowable<List<StationModel>> {
        return repository.getAllStations()
//        else repository.getStationByName(params)
    }

    private fun stationIsValid(stationVIewModel: StationModel): Boolean {
        return (stationVIewModel.nameStation.isNotBlank() &&
                stationVIewModel.phoneNumber.isNotBlank())
    }
}