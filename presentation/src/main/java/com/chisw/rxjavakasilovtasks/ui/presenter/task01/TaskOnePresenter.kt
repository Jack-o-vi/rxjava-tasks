package com.chisw.rxjavakasilovtasks.ui.presenter.task01

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import com.chisw.domain.interactor.UseCase
import com.chisw.domain.interactor.tasks.TaskOneUseCase
import com.chisw.rxjavakasilovtasks.ui.contract.task01.TaskOneContract
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


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
            useCase.execute(TaskOneUseCase.TaskOneParameter(listOf(0, 1)), Consumer { result ->
                Log.d(TAG, "onSuccess ${result.story} ")
                result.story?.forEach { title ->
                    stringBuilder.append(title)
                    stringBuilder.append(System.lineSeparator())
                }
                view.setText(stringBuilder.toString())
            })

//            useCase.execute(TaskOneUseCase.TaskOneParameter(listOf(0, 1)))
//                    ?.subscribe(object : Subscriber<TaskOneUseCase.TaskOneResult> {
//                        override fun onComplete() {
//                            Log.e(TAG, "onComplete:")
//                        }
//
//                        override fun onSubscribe(s: Subscription?) {
//                            Log.e(TAG, "onSubscribe subscription: $s")
//                        }
//
//                        override fun onNext(result: TaskOneUseCase.TaskOneResult?) {
//                            Log.e(TAG, "onSuccess ${result?.story} ")
//                            result?.story?.forEach { title ->
//                                stringBuilder.append(title)
//                                stringBuilder.append(System.lineSeparator())
//                            }
//                            view.setText(stringBuilder.toString())
//                        }
//
//                        override fun onError(e: Throwable?) {
//                            Log.e(TAG, "onError Exception")
//                            e?.printStackTrace()
//                            view.showToast(e.toString())
//                        }
//                    })
        }
    }

    /*
                ?.subscribe(object : Consumer<TaskOneUseCase.TaskOneResult> {
                    override fun onSuccess(result: TaskOneUseCase.TaskOneResult) {
                        Log.d(TAG, "onSuccess ${result.story} ")
                        val stringBuilder = StringBuilder()
                        result.story?.forEach { title ->
                            stringBuilder.append(title)
                            stringBuilder.append(System.lineSeparator())
                        }
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

     */

    override fun unbind() {
        Log.d(TAG, "Unbind $view")
        view = null
        useCase.unsubscribe()
    }
}
