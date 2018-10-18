package com.chisw.domain.interactor

import io.reactivex.Observable
import io.reactivex.functions.Consumer

interface Interactor<P, T> {

    fun execute(params: P, d: Consumer<T>)

    fun execute(params: P): Observable<T>?
}
