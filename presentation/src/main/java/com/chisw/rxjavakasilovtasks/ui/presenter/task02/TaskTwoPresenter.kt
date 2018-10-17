package com.chisw.rxjavakasilovtasks.ui.presenter.task02

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import com.chisw.data.net.specification.task01.TaskOneSpecification
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.interactor.tasks.TaskTwoUseCase
import com.chisw.rxjavakasilovtasks.ui.contract.task02.TaskTwoContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class TaskTwoPresenter(private var useCase: UseCase<TaskTwoUseCase.TaskTwoParameter, TaskTwoUseCase.TaskTwoResult>)
    : TaskTwoContract.TaskTwoPresenter {
    private var view: TaskTwoContract.TaskTwoView? = null

    companion object {
        val TAG = TaskTwoPresenter::class.java.simpleName
    }

    @SuppressLint("CheckResult")
    override fun bind(view: TaskTwoContract.TaskTwoView) {
        this.view = view
        Log.d(TAG, "Bind $view")
        val stringBuilder = StringBuilder()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            useCase.execute(TaskTwoUseCase.TaskTwoParameter(TaskOneSpecification()))
                    ?.subscribe(object : Observer<TaskTwoUseCase.TaskTwoResult> {

                        override fun onComplete() {}

                        override fun onNext(result: TaskTwoUseCase.TaskTwoResult) {
                            Log.d(TAG, "onSuccess ${result.story} ")
                            view.setText(stringBuilder.toString())
                        }

                        override fun onSubscribe(d: Disposable) {
                            Log.e(TAG, "onError Exception $d")
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError Exception")
                            e.printStackTrace()
                            view.showToast(e.toString())
                        }
                    })
        }
    }

    override fun unbind() {
        Log.d(TAG, "Unbind $view")
        view = null
        useCase.unsubscribe()
    }
}