package com.nimtego.armaplc.domain.interactors

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseInteractor( private val disposables: CompositeDisposable) {

    fun dispose() {
        disposables.clear()
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}