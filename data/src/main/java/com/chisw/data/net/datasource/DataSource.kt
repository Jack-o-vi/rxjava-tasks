package com.chisw.data.net.datasource

import com.chisw.domain.abstraction.specification.Specification
import io.reactivex.Single
import okhttp3.ResponseBody

/**
 * DataSources work with data models.
 *
 * @author Vitaly Zeenko
 * @version 0.0.1
 */
interface DataSource<T> {
    fun getResponseBody(specification: Specification?): Single<ResponseBody?>?
    fun getItem(specification: Specification?): Single<T?>?
}