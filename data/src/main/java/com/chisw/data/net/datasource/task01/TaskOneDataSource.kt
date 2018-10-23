package com.chisw.data.net.datasource.task01

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.manager.NetworkManager
import com.chisw.data.net.model.story.DataBean
import com.chisw.data.net.specification.RemoteSpecification
import com.chisw.domain.abstraction.specification.Specification
import io.reactivex.Single
import okhttp3.ResponseBody

class TaskOneDataSource : DataSource<DataBean> {

    companion object {
        val TAG = TaskOneDataSource::class.java.simpleName
    }

    override fun getResponseBody(specification: Specification): Single<ResponseBody> {
        if (specification is RemoteSpecification) {
            specification.args?.get(0).let {
                if (it == null) throw IllegalArgumentException("No arguments were provided in specification. Must be one number argument.")
                return NetworkManager.getAlgoliaApi().getStoriesInString(it.toInt())
            }
        }
        throw IllegalArgumentException("Specification not a Remote")
    }

    override fun getItem(specification: Specification): Single<DataBean> {
        if (specification is RemoteSpecification) {
            specification.args?.get(0).let {
                if (it == null) throw IllegalArgumentException("No arguments were provided in specification. Must be one number argument.")
                Log.d(TAG, "getItem() getStories request page ${this}")
                return NetworkManager.getAlgoliaApi().getStories(it.toInt())
            }
        }
        throw IllegalArgumentException("Specification not a Remote.")
    }
}