package com.chisw.data.net.repository

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Data
import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.model.user.User
import io.reactivex.Single
import okhttp3.ResponseBody
import com.chisw.domain.model.story.Data as DomainData

class RepositoryImpl(private var dataSource: DataSource<Data?>?,
                     private var userDataSource: DataSource<User?>?,
                     private var mapper: Mapper<Data, DomainData>) : Repository {

    companion object {
       val TAG = RepositoryImpl::class.java.simpleName
    }

    override fun taskOne(page: Specification?): Single<DomainData?>? {
        Log.d(TAG, "Specification: $page")
        return dataSource?.getItem(page)?.map { data ->
            data?.let {
                return@map mapper.map(it)
            }
        }
    }

    override fun taskTwo(page: Specification?): Single<User?>? {
        Log.d(TAG, "Specification: $page")
        return userDataSource?.getItem(page)?.map { data ->
            data?.let {
                return@map null
            }
        }
    }

    override fun taskOneString(page: Specification?): Single<ResponseBody?>? {
        Log.d(TAG, "Specification String: $page")
        return dataSource?.getResponseBody(page)
    }
}