package com.chisw.domain.abstraction.repository

import com.chisw.domain.abstraction.specification.Specification
import com.chisw.domain.model.story.Data
import io.reactivex.Single
import okhttp3.ResponseBody

interface Repository {
    fun taskOne(page: Specification?): Single<Data?>?
    fun taskOneString(page: Specification?): Single<ResponseBody?>?
}
