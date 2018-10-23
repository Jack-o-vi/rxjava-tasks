package com.chisw.data.net.repository

import android.util.Log
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.DataBean
import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.model.user.UserEntity
import io.reactivex.Single
import okhttp3.ResponseBody
import com.chisw.data.net.model.user.UserBean as DataUser
import com.chisw.domain.model.story.DataEntity as DomainData

class RepositoryImpl(private val dataSource: DataSource<DataBean>,
                     private val userDataSource: DataSource<DataUser>,
                     private val mapper: Mapper<DataBean, DomainData>,
                     private val userToDomainUserMapper: Mapper<DataUser, UserEntity>) : Repository {

    companion object {
        val TAG = RepositoryImpl::class.java.simpleName
    }

    override fun taskOne(page: Specification): Single<DomainData> {
        Log.d(TAG, "Specification: ${page.args?.get(0)}")
        return dataSource.getItem(page).map { data ->
            data?.let {
                return@map mapper.map(it)
            }
        }
    }

    override fun taskTwo(page: Specification): Single<UserEntity> {
        Log.d(TAG, "RepositoryImpl taskTwo() Specification: ${page.args?.get(0)} and ${page.args?.get(1)}")
        return userDataSource.getItem(page).map { data ->
            data?.let { user ->
                return@map userToDomainUserMapper.map(user)
            }
        }
    }

    override fun taskOneString(page: Specification): Single<ResponseBody> {
        Log.d(TAG, "Specification String: $page")
        return dataSource.getResponseBody(page)
    }
}