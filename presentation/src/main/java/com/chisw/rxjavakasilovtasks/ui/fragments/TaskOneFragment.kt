package com.chisw.rxjavakasilovtasks.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chisw.domain.interactor.tasks.TaskOneUseCase
import com.chisw.rxjavakasilovtasks.R
import com.chisw.rxjavakasilovtasks.core.App
import com.chisw.rxjavakasilovtasks.ui.contract.task01.TaskOneContract
import com.chisw.rxjavakasilovtasks.ui.presenter.task01.TaskOnePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.task1_fragment.*

class TaskOneFragment : AbstractTaskFragment(), TaskOneContract.TaskOneView {

    private var presenter: TaskOneContract.TaskOnePresenter? = null


    companion object {
        val TAG = TaskOneFragment::class.java.simpleName

        fun newInstance(): TaskOneFragment {
            return TaskOneFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflateView(R.layout.task1_fragment, inflater, container)

        Log.d(TAG, "onCreateView")

        App.repository?.let {
            presenter = TaskOnePresenter(TaskOneUseCase(it, { Schedulers.io() }, { AndroidSchedulers.mainThread() }))
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        presenter?.bind(this)
    }

    override fun onPause() {
        super.onPause()
        presenter?.unbind()
    }

    override fun showToast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
    }

    override fun setText(string: String?) {
        tvInformation.text = string
    }
}