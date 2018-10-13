package com.chisw.rxjavakasilovtasks.ui.fragments

import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractTaskFragment : Fragment() {

    protected fun inflateView(@LayoutRes layoutId: Int,
                              inflater: LayoutInflater,
                              container: ViewGroup?): View? {
        return inflater.inflate(layoutId, container, false)
    }

}