package com.chisw.domain.interactor.tasks

import com.chisw.domain.interactor.UseCase
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.*

class TaskFourUseCase(
        threadExecution: () -> Scheduler,
        postExecutionThread: () -> Scheduler
) : UseCase<TaskFourUseCase.TaskFourUseCaseParameter,
        TaskFourUseCase.TaskFourUseCaseResult>(threadExecution, postExecutionThread) {

    override fun createObservable(params: TaskFourUseCaseParameter): Observable<TaskFourUseCaseResult>? {
        return null
    }

    override fun createMaybe(params: TaskFourUseCase.TaskFourUseCaseParameter): Maybe<TaskFourUseCase.TaskFourUseCaseResult>? {
        return Maybe.create<String> { emitter ->
            if (Random().nextBoolean()) {
                if (!emitter.isDisposed) {
                    emitter.onSuccess("Bang!")
                }
            } else {
                if (!emitter.isDisposed) {
                    emitter.onComplete()
                }
            }
        }.map {
            TaskFourUseCaseResult(it)
        }
    }

    class TaskFourUseCaseParameter : UseCase.UseCaseParameter
    class TaskFourUseCaseResult(val res: String) : UseCase.UseCaseResult
}
