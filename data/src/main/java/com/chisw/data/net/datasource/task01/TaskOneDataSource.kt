package com.chisw.data.net.datasource.task01

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.manager.NetworkManager
import com.chisw.data.net.model.story.Data
import com.chisw.data.net.specification.RemoteSpecification
import com.chisw.domain.abstraction.specification.Specification
import io.reactivex.Single
import okhttp3.ResponseBody

class TaskOneDataSource : DataSource<Data?> {

    companion object {
        val TAG = TaskOneDataSource::class.java.simpleName
    }

    override fun getResponseBody(specification: Specification?): Single<ResponseBody?>? {
        if (specification is RemoteSpecification) {
            specification.getParameters()?.get(0)?.apply {
                return NetworkManager.getAlgoliaApi()?.getStoriesInString(toInt())
            }
        }
        return null
    }

    override fun getItem(specification: Specification?): Single<Data?>? {
        if (specification is RemoteSpecification) {
            specification.getParameters()?.get(0)?.apply {
                Log.d(TAG, "getItem() getStories request page ${this}")
                return NetworkManager.getAlgoliaApi()?.getStories(toInt())
            }
        }
        return null
    }
}