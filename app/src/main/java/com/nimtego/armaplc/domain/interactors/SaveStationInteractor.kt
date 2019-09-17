package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.SchedulersProvider
import com.nimtego.armaplc.presentation.model.StationModel
import io.reactivex.Completable
import javax.inject.Inject

class SaveStationInteractor @Inject constructor(
    private val repository: StationRepository,
    private val schedulersProvider: SchedulersProvider
) : CompletableInteractor<StationModel>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseCompletable(params: StationModel?): Completable {
        return if (params != null && stationIsValid(params)) {
            repository.saveStation(params)
        } else {
            Completable.error(IllegalArgumentException("Name station or phone number can't be empty"))
        }
    }

    //todo
    private fun stationIsValid(stationVIewModel: StationModel): Boolean {
        return (stationVIewModel.nameStation.isNotBlank() &&
                stationVIewModel.phoneNumber.isNotBlank())
    }
}