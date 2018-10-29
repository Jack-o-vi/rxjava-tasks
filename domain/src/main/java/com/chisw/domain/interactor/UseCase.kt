package com.chisw.domain.interactor

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.functions.Consumer

abstract class UseCase<P : UseCase.UseCaseParameter, R : UseCase.UseCaseResult>
(private val threadExecutor: () -> Scheduler, private val postExecutionThread: () -> Scheduler)
    : Interactor<P, R> {

    private var disposable: Disposable? = Disposables.empty()

    protected abstract fun createObservable(params: P): Observable<R>?

    protected open fun createMaybe(params: P): Maybe<R>? {
        return null
    }

    override fun execute(params: P, d: Consumer<R>) {
        disposable =
                createObservable(params)
                        ?.subscribeOn(threadExecutor.invoke())
                        ?.observeOn(postExecutionThread.invoke())
                        ?.subscribe(d)
    }

    override fun execute(params: P): Observable<R>? {
        return createObservable(params)
                ?.subscribeOn(threadExecutor.invoke())
                ?.observeOn(postExecutionThread.invoke())
    }

    fun executeMaybe(params: P): Maybe<R>? {
        return createMaybe(params)
                ?.subscribeOn(threadExecutor.invoke())
                ?.observeOn(postExecutionThread.invoke())
    }

    fun unsubscribe() {
        disposable?.apply {
            if (!isDisposed) {
                dispose()
            }
        }
    }

    interface UseCaseParameter

    interface UseCaseResult
}
