package com.chisw.data.net.specification.task01

import com.chisw.data.net.specification.RemoteSpecification

class TaskOneSpecification : RemoteSpecification {
    override val args: Array<String>? = arrayOf("0", "1")

    override fun <T> getBody(): T? {
        return null
    }

}