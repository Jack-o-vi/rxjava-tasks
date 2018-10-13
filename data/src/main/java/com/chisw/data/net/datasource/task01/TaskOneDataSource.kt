package com.chisw.data.net.datasource.task01

import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.manager.NetworkManager
import com.chisw.data.net.model.story.Data
import com.chisw.data.net.model.user.User
import io.reactivex.Single
import okhttp3.ResponseBody

class TaskOneDataSource : DataSource {

    override fun getUser(username:String?): Single<User>? {
        return NetworkManager.getAlgoliaApi()?.getUsers(username)
    }

    override fun getStoriesByPage(page:Int?): Single<Data>? {
        return NetworkManager.getAlgoliaApi()?.getStories(page)
    }

    override fun getStoriesByPageString(page:Int?): Single<ResponseBody>? {
        return NetworkManager.getAlgoliaApi()?.getStoriesInString(page)
    }
}