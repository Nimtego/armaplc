package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.DiskStationDataSource
import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.view_model.StationViewModel
import io.reactivex.Completable
import javax.inject.Inject

class SaveStationInteractor @Inject constructor(
    private val repository: StationRepository,
    private val schedulersProvider: SchedulersProvider
) : CompletableInteractor<StationViewModel>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseCompletable(params: StationViewModel?): Completable {
        return if (params != null && stationIsValid(params)) {
            repository.saveStation(params)
        } else {
            Completable.error(IllegalArgumentException("StationEntity is invalid"))
        }
    }

    //todo
    private fun stationIsValid(stationVIewModel: StationViewModel): Boolean {
        return (stationVIewModel.nameStation.isNotBlank() &&
                stationVIewModel.phoneNumber.isNotBlank())
    }
}