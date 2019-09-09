package com.nimtego.armaplc.domain.interactors

import com.nimtego.armaplc.presentation.SchedulersProvider
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

abstract class FlowableInteractor<T, in Params> constructor(
    private val scheduler: SchedulersProvider
) : BaseInteractor(CompositeDisposable()) {

    abstract fun buildUseCaseFlowable(params: Params? = null): Flowable<T>

    abstract fun providePostExecutionThread(): Scheduler

    open fun execute(
        params: Params? = null,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onComplete: (() -> Unit)? = null
    ) {
        val flowable = this.buildUseCaseFlowable(params)
            .subscribeOn(scheduler.io())
            .observeOn(providePostExecutionThread())
        addDisposable(flowable.subscribe(
            { t: T -> onNext.invoke(t) },
            { error -> onError.invoke(error) },
            { onComplete?.invoke() }
        ))
    }
}