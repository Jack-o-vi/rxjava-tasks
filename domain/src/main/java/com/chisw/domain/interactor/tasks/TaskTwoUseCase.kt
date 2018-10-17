package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.model.user.User
import io.reactivex.Observable
import io.reactivex.Scheduler

/*
Task 2
1. Get list of stories from page 0
2. For all stories load author’s info
3. Print only authors with karma greater than 3000 as a single list
*/

class TaskTwoUseCase(private var repository: Repository,
                     threadExecutor: () -> Scheduler,
                     postExecutionThread: () -> Scheduler)
    : UseCase<TaskTwoUseCase.TaskTwoParameter, TaskTwoUseCase.TaskTwoResult>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: TaskTwoParameter): Observable<TaskTwoResult>? {
        return repository.taskOne(params.specification)
                ?.toObservable()
                ?.flatMap { data ->
                    val resList = data.hits?.map { hit -> hit.author }
                    return@flatMap Observable.fromIterable(resList?.asIterable())
                }?.flatMap { author ->
                    return@flatMap repository.taskTwo(params.specification)?.toObservable()
                }?.filter { user ->
                    var condition = false
                    user.karma?.let {
                        condition = it > 3_000
                    }
                    return@filter condition
                }?.map {
                    return@map TaskTwoResult(it)
                }
    }

    class TaskTwoParameter(var specification: Specification) : UseCase.UseCaseParameter

    class TaskTwoResult(val story: User? = null) : UseCase.UseCaseResult
}