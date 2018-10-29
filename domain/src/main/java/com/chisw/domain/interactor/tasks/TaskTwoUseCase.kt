package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.model.user.UserEntity
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
        return repository.taskOne(params.specification).toObservable()
                ?.flatMap { data ->
                    val resList = data.hits?.map { hit -> hit.author }
                    Observable.fromIterable(resList?.asIterable())
                }?.flatMap { author ->
                    params.specification.args?.set(0, author)
                    repository.taskTwo(params.specification).toObservable()
                }?.filter { user ->
                    user.karma?.let { it > 3000 } ?: false
                }?.buffer(20)?.map {
                    TaskTwoResult(it)
                }
    }

    class TaskTwoParameter(var specification: Specification) : UseCase.UseCaseParameter

    class TaskTwoResult(val user: MutableList<UserEntity>) : UseCase.UseCaseResult
}