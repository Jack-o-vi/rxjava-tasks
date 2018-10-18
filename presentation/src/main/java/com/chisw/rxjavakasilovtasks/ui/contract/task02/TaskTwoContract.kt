package com.chisw.rxjavakasilovtasks.ui.contract.task02

import com.chisw.rxjavakasilovtasks.ui.contract.BasePresenter
import com.chisw.rxjavakasilovtasks.ui.contract.BaseView

class TaskTwoContract {
    interface TaskTwoPresenter : BasePresenter<TaskTwoView>
    interface TaskTwoView : BaseView<TaskTwoPresenter> {
        fun showToast(string: String?)
        fun setText(string: String?)
    }
}