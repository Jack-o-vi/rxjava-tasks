package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.interactor.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single

class TaskOneUseCase(private var repository: Repository,
                     threadExecutor: () -> Scheduler,
                     postExecutionThread: () -> Scheduler)
    : UseCase<TaskOneUseCase.TaskOneParameter, TaskOneUseCase.TaskOneResult>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: TaskOneParameter): Single<TaskOneResult>? {
        return repository.taskOne(params.arrayInt[0])
                ?.mergeWith(repository.taskOne(params.arrayInt[1]))
                ?.single(null)
                ?.map { data ->
                    data.hits?.map { hit -> hit.title }?.let { titles ->
                        TaskOneResult(titles)
                    }
                }

    }

    /*

    return repository.taskOne(params.arrayInt[0])
                ?.mergeWith(repository.taskOne(params.arrayInt[1]))
                ?.map { data ->
                    data.hits?.map { hit -> hit.title }?.let { titles ->
                        TaskOneResult(titles)
                    }
                }

     */

    class TaskOneParameter(var arrayInt: List<Int>) : UseCase.UseCaseParameter

    class TaskOneResult(val story: List<String?>? = null) : UseCase.UseCaseResult
}