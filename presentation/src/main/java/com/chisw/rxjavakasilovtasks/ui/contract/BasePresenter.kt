package com.chisw.rxjavakasilovtasks.ui.contract

interface BasePresenter<T> {
    fun bind(view: T)
    fun unbind()
}