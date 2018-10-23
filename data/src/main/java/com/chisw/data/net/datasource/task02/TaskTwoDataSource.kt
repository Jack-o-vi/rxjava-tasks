package com.chisw.data.net.datasource.task02

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.datasource.task01.TaskOneDataSource
import com.chisw.data.net.manager.NetworkManager
import com.chisw.data.net.model.user.UserBean
import com.chisw.data.net.specification.RemoteSpecification
import com.chisw.domain.abstraction.specification.Specification
import io.reactivex.Single
import okhttp3.ResponseBody

class TaskTwoDataSource : DataSource<UserBean> {
    override fun getResponseBody(specification: Specification): Single<ResponseBody> {
        throw NotImplementedError("Method is not implemented TaskTwoDataSource.getResponseBody(specification)")
    }

    override fun getItem(specification: Specification): Single<UserBean> {
        if (specification is RemoteSpecification) {
            specification.args?.get(0).let {
                if (it == null) throw IllegalArgumentException("No arguments were provided in specification. Must be one number argument.")
                Log.d(TaskOneDataSource.TAG, "getItem() getStories request page ${this}")
                return NetworkManager.getAlgoliaApi().getUsers(it)
            }
        }
        throw IllegalArgumentException("Specification is not a RemoteSpecification.")

    }
}