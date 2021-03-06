package com.chisw.rxjavakasilovtasks.ui.presenter.task01

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import com.chisw.data.net.specification.task01.TaskOneSpecification
import com.chisw.data.net.specification.task01.TaskOneSpecification2
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.interactor.tasks.TaskOneUseCase
import com.chisw.rxjavakasilovtasks.ui.contract.task01.TaskOneContract
import com.chisw.rxjavakasilovtasks.ui.presenter.task02.TaskTwoPresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class TaskOnePresenter(private var useCase: UseCase<TaskOneUseCase.TaskOneParameter, TaskOneUseCase.TaskOneResult>)
    : TaskOneContract.TaskOnePresenter {

    private var view: TaskOneContract.TaskOneView? = null

    companion object {
        val TAG = TaskOnePresenter::class.java.simpleName
    }

    @SuppressLint("CheckResult")
    override fun bind(view: TaskOneContract.TaskOneView) {
        this.view = view
        Log.d(TAG, "Bind $view")
        val stringBuilder = StringBuilder()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            useCase.execute(TaskOneUseCase.TaskOneParameter(TaskOneSpecification(), TaskOneSpecification2()))
                    ?.subscribe(object : Observer<TaskOneUseCase.TaskOneResult> {

                        override fun onComplete() {
                            Log.d(TaskTwoPresenter.TAG, "onComplete")
                        }

                        override fun onNext(result: TaskOneUseCase.TaskOneResult) {
                            Log.d(TAG, "onSuccess ${result.story} ")
                            result.story?.forEach { title ->
                                stringBuilder.append(title)
                                stringBuilder.append(System.lineSeparator())
                            }
                            view.setText(stringBuilder.toString())
                        }

                        override fun onSubscribe(d: Disposable) {
                            Log.d(TaskTwoPresenter.TAG, "onSubscribe Disposable $d")
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
