package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.interactor.UseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class TaskOneUseCase(private var repository: Repository,
                     threadExecutor: () -> Scheduler,
                     postExecutionThread: () -> Scheduler)
    : UseCase<TaskOneUseCase.TaskOneParameter, TaskOneUseCase.TaskOneResult>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: TaskOneParameter): Single<TaskOneResult>? {
        return repository.taskOne(params.specification)
                ?.zipWith(repository.taskOne(params.specification), BiFunction { data1, data2 ->
                    val listRes = ArrayList<String?>()
                    data1.hits?.map { hit -> hit.title }?.let { titles ->
                        listRes.addAll(titles)
                    }
                    data2.hits?.map { hit -> hit.title }?.let { titles ->
                        listRes.addAll(titles)
                    }
                    return@BiFunction TaskOneResult(listRes)
                })
    }

    /*
ver 0.1
repository.taskOne(params.arrayInt[0])
                ?.mergeWith(repository.taskOne(params.arrayInt[1]))
                ?.map { data ->
                    data.hits?.map { hit -> hit.title }?.let { titles ->
                        TaskOneResult(titles)
                    }
                }
                ?.single(TaskOneResult())


    return repository.taskOne(params.arrayInt[0])
                ?.mergeWith(repository.taskOne(params.arrayInt[1]))
                ?.map { data ->
                    data.hits?.map { hit -> hit.title }?.let { titles ->
                        TaskOneResult(titles)
                    }
                }

     */

    class TaskOneParameter(var specification: Specification) : UseCase.UseCaseParameter

    class TaskOneResult(val story: List<String?>? = null) : UseCase.UseCaseResult
}