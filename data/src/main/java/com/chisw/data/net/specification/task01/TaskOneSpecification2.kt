package com.chisw.data.net.specification.task01

import com.chisw.data.net.specification.RemoteSpecification

class TaskOneSpecification2 : RemoteSpecification {
    override val args: Array<String>? = arrayOf("1")

    override fun <T> getBody(): T? {
        return null
    }

}