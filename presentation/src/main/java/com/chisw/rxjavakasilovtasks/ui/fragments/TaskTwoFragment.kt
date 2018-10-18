package com.chisw.rxjavakasilovtasks.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chisw.domain.interactor.tasks.TaskTwoUseCase
import com.chisw.rxjavakasilovtasks.R
import com.chisw.rxjavakasilovtasks.core.App
import com.chisw.rxjavakasilovtasks.ui.contract.task02.TaskTwoContract
import com.chisw.rxjavakasilovtasks.ui.presenter.task02.TaskTwoPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.task1_fragment.*

class TaskTwoFragment : AbstractTaskFragment(), TaskTwoContract.TaskTwoView {
    private var presenter: TaskTwoContract.TaskTwoPresenter? = null

    companion object {
        val TAG = TaskTwoFragment::class.java.simpleName

        fun newInstance(): TaskTwoFragment {
            return TaskTwoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflateView(R.layout.task1_fragment, inflater, container)

        Log.d(TAG, "onCreateView")

        App.repository?.let {
            presenter = TaskTwoPresenter(TaskTwoUseCase(it, { Schedulers.io() }, { AndroidSchedulers.mainThread() }))
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