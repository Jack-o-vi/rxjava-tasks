package com.chisw.data.net.datasource.task02

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.datasource.task01.TaskOneDataSource
import com.chisw.data.net.manager.NetworkManager
import com.chisw.data.net.model.user.User
import com.chisw.data.net.specification.RemoteSpecification
import com.chisw.domain.abstraction.specification.Specification
import io.reactivex.Single
import okhttp3.ResponseBody

class TaskTowDataSource : DataSource<User?> {
    override fun getResponseBody(specification: Specification?): Single<ResponseBody?>? {
        return null
    }

    override fun getItem(specification: Specification?): Single<User?>? {
        if (specification is RemoteSpecification) {
            specification.getParameters()?.get(0)?.let {
                Log.d(TaskOneDataSource.TAG, "getItem() getStories request page ${this}")
                return NetworkManager.getAlgoliaApi()?.getUsers(it)
            }
        }
        return null
    }
}