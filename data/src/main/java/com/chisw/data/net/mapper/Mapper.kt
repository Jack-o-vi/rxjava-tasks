package com.chisw.data.net.mapper

interface Mapper<F, T> {
    fun map(from: F): T
}