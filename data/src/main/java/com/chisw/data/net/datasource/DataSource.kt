package com.chisw.data.net.datasource

import com.chisw.data.net.model.story.Data
import com.chisw.data.net.model.user.User
import io.reactivex.Single
import okhttp3.ResponseBody

interface DataSource {
    fun getUser(username: String?): Single<User>?

    fun getStoriesByPage(page: Int?): Single<Data>?

    fun getStoriesByPageString(page: Int?): Single<ResponseBody>?
}