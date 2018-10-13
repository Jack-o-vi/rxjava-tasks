package com.chisw.domain.interactor

import io.reactivex.Single
import io.reactivex.functions.Consumer

interface Interactor<P, T> {

    fun execute(params: P, d: Consumer<T>)

    fun execute(params: P): Single<T>?
}
