package com.chisw.rxjavakasilovtasks.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chisw.rxjavakasilovtasks.R
import com.chisw.rxjavakasilovtasks.ui.contract.task03.TaskThreeContract
import com.chisw.rxjavakasilovtasks.ui.presenter.task03.TaskThreePresenter
import kotlinx.android.synthetic.main.task1_fragment.*

class TaskThreeFragment : AbstractTaskFragment(), TaskThreeContract.TaskThreeView {
    private var presenter: TaskThreeContract.TaskThreePresenter? = null

    companion object {
        val TAG = TaskThreeFragment::class.java.simpleName

        fun newInstance(): TaskThreeFragment {
            return TaskThreeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflateView(R.layout.task1_fragment, inflater, container)
        Log.d(TAG, "onCreateView")
        setText(TAG)
        presenter = TaskThreePresenter()
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
        tvInformation?.text = string
    }
}