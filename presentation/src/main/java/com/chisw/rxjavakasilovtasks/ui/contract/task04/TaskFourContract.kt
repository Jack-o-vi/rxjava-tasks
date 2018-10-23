package com.chisw.rxjavakasilovtasks.ui.contract.task04

import com.chisw.rxjavakasilovtasks.ui.contract.BasePresenter
import com.chisw.rxjavakasilovtasks.ui.contract.BaseView

interface TaskFourContract {
    interface TaskFourView : BaseView<TaskFourPresenter> {
        fun showToast(string: String?)
        fun setText(string: String?)
    }

    interface TaskFourPresenter : BasePresenter<TaskFourView>
}