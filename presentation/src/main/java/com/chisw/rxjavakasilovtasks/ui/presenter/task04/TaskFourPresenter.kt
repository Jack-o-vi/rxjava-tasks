package com.chisw.rxjavakasilovtasks.ui.presenter.task04

import com.chisw.domain.interactor.UseCase
import com.chisw.domain.interactor.tasks.TaskFourUseCase
import com.chisw.rxjavakasilovtasks.ui.contract.task04.TaskFourContract

class TaskFourPresenter(private var useCase: UseCase<TaskFourUseCase.TaskFourUseCaseParameter,
        TaskFourUseCase.TaskFourUseCaseResult>) : TaskFourContract.TaskFourPresenter {


    var view: TaskFourContract.TaskFourView? = null

    companion object {
        val TAG = TaskFourPresenter::class.java
    }

    override fun bind(view: TaskFourContract.TaskFourView) {
        this.view = view
    }

    fun handleTaskFour() {
    }

    override fun unbind() {
        view = null
    }
}