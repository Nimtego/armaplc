package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.presentation.scheduler.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableInteractor<in Params> constructor(
    private val scheduler: SchedulersProvider
) : BaseInteractor(CompositeDisposable()) {

    abstract fun buildUseCaseCompletable(params: Params? = null): Completable

    abstract fun providePostExecutionThread(): Scheduler

    open fun execute(
        params: Params? = null,
        complete: () -> Unit,
        error: (e: Throwable) -> Unit
    ) {
        val completable = this.buildUseCaseCompletable(params)
            .subscribeOn(scheduler.io())
            .observeOn(providePostExecutionThread())
        addDisposable(completable.subscribeWith(object : DisposableCompletableObserver() {
            override fun onComplete() {
                complete()
            }

            override fun onError(e: Throwable) {
                error(e)
            }
        }))
    }
}