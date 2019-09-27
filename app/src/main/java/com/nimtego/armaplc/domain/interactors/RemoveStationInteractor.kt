package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.data.repository.StationRepository
import com.nimtego.armaplc.presentation.model.Station
import com.nimtego.armaplc.presentation.scheduler.SchedulersProvider
import io.reactivex.Completable
import javax.inject.Inject

class RemoveStationInteractor @Inject constructor(
    private val repository: StationRepository,
    private val schedulersProvider: SchedulersProvider
) : CompletableInteractor<Station>(schedulersProvider) {

    override fun providePostExecutionThread() = this.schedulersProvider.ui()

    override fun buildUseCaseCompletable(params: Station?): Completable {
        return if (params != null && stationIsValid(params)) {
            repository.removeStation(params)
        } else {
            Completable.error(IllegalArgumentException("Name station or phone number can't be empty"))
        }
    }

    //todo
    private fun stationIsValid(stationVIew: Station): Boolean {
        return (stationVIew.nameStation.isNotBlank() &&
                stationVIew.phoneNumber.isNotBlank())
    }
}