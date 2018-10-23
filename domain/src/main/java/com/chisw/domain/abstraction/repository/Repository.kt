package com.chisw.domain.abstraction.repository

import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.model.story.DataEntity
import com.chisw.domain.model.user.UserEntity
import io.reactivex.Single
import okhttp3.ResponseBody

interface Repository {
    fun taskOne(page: Specification): Single<DataEntity>
    fun taskTwo(page: Specification): Single<UserEntity>
    fun taskOneString(page: Specification): Single<ResponseBody>
}
