package com.moura.randomizeme.common

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

class AndroidDisposable {

    companion object {
        fun Disposable.addTo(androidDisposable: AndroidDisposable) {
            androidDisposable.add(this)
        }
    }

    private var compositeDisposable = CompositeDisposable()

    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun disposeAll() {
        compositeDisposable.dispose()
        compositeDisposable = CompositeDisposable()
    }

}