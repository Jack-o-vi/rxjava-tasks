package com.chisw.domain.executors

import io.reactivex.Scheduler

interface ThreadExecutor {
    fun threadExecutorSchedulers(): Scheduler
}
