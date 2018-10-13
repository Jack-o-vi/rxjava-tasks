package com.chisw.data.net.repository

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.model.story.Data
import io.reactivex.Single
import okhttp3.ResponseBody

class RepositoryImpl(private var dataSource: DataSource?,
                     private var mapper: Mapper<com.chisw.data.net.model.story.Data, Data>) : Repository {

    companion object {
       val TAG = RepositoryImpl::class.java.simpleName
    }

    override fun taskOne(page: Int?): Single<Data>? {
        Log.d(TAG, "Specification: $page")
        return dataSource?.getStoriesByPage(page)?.map { mapper.map(it) }
    }

    override fun taskOneString(page: Int?): Single<ResponseBody>? {
        Log.d(TAG, "Specification String: $page")
        return dataSource?.getStoriesByPageString(page)
    }
}