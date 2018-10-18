package com.chisw.rxjavakasilovtasks.ui.contract.task03

import com.chisw.rxjavakasilovtasks.ui.contract.BasePresenter
import com.chisw.rxjavakasilovtasks.ui.contract.BaseView

interface TaskThreeContract {
    interface TaskThreeView : BaseView<TaskThreePresenter> {
        fun showToast(string: String?)
        fun setText(string: String?)
    }

    interface TaskThreePresenter : BasePresenter<TaskThreeView>
}