package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.view_model.StationViewModel
import io.reactivex.Completable

class SaveStationInteractor(private val repository: StationRepository,
                            val schedulersProvider: SchedulersProvider
): CompletableInteractor<StationViewModel>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseCompletable(params: StationViewModel?): Completable {
        return if (params != null && stationIsValid(params)) {
            repository.saveStation(params)
        } else {
            Completable.error(IllegalArgumentException("StationEntity is invalid"))
        }
    }

    private fun stationIsValid(stationVIewModel: StationViewModel): Boolean {
        return (stationVIewModel.nameStation.isNotBlank() &&
                stationVIewModel.phoneNumber.isNotBlank())
    }
}