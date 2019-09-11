package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.view_model.StationViewModel
import io.reactivex.Completable
import io.reactivex.Flowable

class StationInteractor(private val repository: StationRepository,
                        val schedulersProvider: SchedulersProvider
): FlowableInteractor<List<StationViewModel>, String?>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseFlowable(params: String?): Flowable<List<StationViewModel>> {
        return repository.getAllStations()
//        else repository.getStationByName(params)
    }

    private fun stationIsValid(stationVIewModel: StationViewModel): Boolean {
        return (stationVIewModel.nameStation.isNotBlank() &&
                stationVIewModel.phoneNumber.isNotBlank())
    }
}