package com.chisw.data.net.specification

import com.chisw.domain.abstraction.specification.Specification

interface RemoteSpecification : Specification {
    fun <T> getBody(): T?
}