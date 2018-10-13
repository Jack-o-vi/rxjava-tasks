package com.chisw.rxjavakasilovtasks.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.chisw.rxjavakasilovtasks.ui.fragments.TaskOneFragment

class TaskActivity : AbstractTasksActivity() {

    override fun createFragment(): Fragment? {
        return TaskOneFragment.newInstance()
    }

    companion object {
        fun newInstance(context: Context):Intent {
            return Intent(context, TaskActivity::class.java)
        }
    }

}