package com.chisw.domain.interactor.tasks

import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.model.user.UserEntity
import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.logging.Level
import java.util.logging.Logger

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
    private val logger = Logger.getLogger(TaskTwoUseCase::class.java.simpleName)

    override fun createObservable(params: TaskTwoParameter): Observable<TaskTwoResult>? {
        return repository.taskOne(params.specification).toObservable()
                ?.flatMap { data ->
                    val resList = data.hits?.map { hit -> hit.author }
                    logInfo("1. flatMap data: $data \n resultList: $resList")
                    Observable.fromIterable(resList?.asIterable())
                }?.flatMap { author ->
                    params.specification.args?.set(0, author)
                    logInfo("2. flatMap author: $author \n Specification args: ${params.specification.args?.get(0)} and ${params.specification.args?.get(1)}")
                    repository.taskTwo(params.specification).toObservable()
                }?.filter { user ->
                    user.karma?.let { it > 3000 } ?: false
                }?.buffer(20)?.map {
                    logInfo("4. map UserEntity : $it")
                    TaskTwoResult(it)
                }
    }

    private fun logInfo(msg: String?) {
        val defaultMsg = "Default message"
        if (msg != null) {
            logger.log(Level.INFO, msg)
        } else {
            logger.log(Level.INFO, defaultMsg)
        }
    }

    class TaskTwoParameter(var specification: Specification) : UseCase.UseCaseParameter

    class TaskTwoResult(val user: MutableList<UserEntity>) : UseCase.UseCaseResult
}