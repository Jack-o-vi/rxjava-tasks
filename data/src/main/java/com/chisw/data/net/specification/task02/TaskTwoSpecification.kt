package com.chisw.data.net.specification.task02

import com.chisw.data.net.specification.RemoteSpecification

class TaskTwoSpecification : RemoteSpecification {
    override fun getParameters(): Array<String>? {
        return null
    }

    override fun <T> getBody(): T? {
        return null
    }

    override val args: Array<String?>? = arrayOf("0", "author_name")
}