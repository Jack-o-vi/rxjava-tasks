package com.chisw.data.net.specification.task01

import com.chisw.data.net.specification.RemoteSpecification

class TaskOneSpecification : RemoteSpecification {
    override fun getParameters(): Array<String>? {
        return arrayOf("1", "2")
    }

    override fun <T> getBody(): T? {
        return null
    }
}