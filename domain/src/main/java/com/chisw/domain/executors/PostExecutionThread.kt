package com.chisw.domain.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun scheduler(): Scheduler
}
