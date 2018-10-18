package com.chisw.rxjavakasilovtasks.ui.activity

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.chisw.rxjavakasilovtasks.ui.fragments.TaskOneFragment
import com.chisw.rxjavakasilovtasks.ui.fragments.TaskThreeFragment
import com.chisw.rxjavakasilovtasks.ui.fragments.TaskTwoFragment

class TaskActivity : AbstractTasksActivity() {

    override fun createFragment(): Fragment? {
        val fragmentTask = intent.getStringExtra(TASK_FRAGMENT_KEY)
        return when (fragmentTask) {
            activitiesList[0] -> TaskOneFragment.newInstance()
            activitiesList[1] -> TaskTwoFragment.newInstance()
            activitiesList[2] -> TaskThreeFragment.newInstance()
            else -> TaskOneFragment.newInstance()
        }
    }

    companion object {
        private const val TASK_FRAGMENT_KEY = "fragment_key"
        val activitiesList = listOf("TaskOneFragment", "TaskTwoFragment", "TaskThreeFragment")

        fun newInstance(context: Context, task: String? = null): Intent {
            val intent = Intent(context, TaskActivity::class.java)
            task?.let {
                intent.putExtra(TASK_FRAGMENT_KEY, it)
            }
            return intent
        }
    }

}