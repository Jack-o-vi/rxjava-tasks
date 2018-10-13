package com.chisw.rxjavakasilovtasks.ui.contract.task01

import com.chisw.rxjavakasilovtasks.ui.contract.BasePresenter
import com.chisw.rxjavakasilovtasks.ui.contract.BaseView

interface TaskOneContract {
    interface TaskOnePresenter : BasePresenter<TaskOneView>
    interface TaskOneView : BaseView<TaskOnePresenter> {
        fun showToast(string: String?)
        fun setText(string: String?)
    }
}