package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.model.story.Data
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.functions.BiFunction

class TaskOneUseCase(private var repository: Repository,
                     threadExecutor: () -> Scheduler,
                     postExecutionThread: () -> Scheduler)
    : UseCase<TaskOneUseCase.TaskOneParameter, TaskOneUseCase.TaskOneResult>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: TaskOneParameter): Observable<TaskOneResult>? {
        return repository.taskOne(params.specification)
                ?.zipWith(repository.taskOne(params.specification2), BiFunction<Data?, Data?, TaskOneResult> { data1, data2 ->
                    val listRes: MutableList<String?>? = null
                    data1.hits?.map { hit -> hit.title }?.let { titles1 ->
                        data2.hits?.map { hit -> hit.title }?.let { titles2 ->
                            if (titles1 is MutableList && titles2 is MutableList) {
                                titles1.addAll(titles2)
                                return@BiFunction TaskOneResult(titles1)
                            }
                        }
                    }
                    return@BiFunction TaskOneResult(listRes)
                })?.toObservable()
    }

    class TaskOneParameter(var specification: Specification,
                           var specification2: Specification) : UseCase.UseCaseParameter

    class TaskOneResult(val story: List<String?>? = null) : UseCase.UseCaseResult
}