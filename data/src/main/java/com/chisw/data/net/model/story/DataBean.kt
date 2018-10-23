package com.chisw.data.net.model.story

data class DataBean(
        val hits: MutableList<HitBean>? = null,
        val page: Int? = null,
        val nbHits: Int? = null,
        val nbPages: Int? = null,
        val hitsPerPage: Int? = null,
        val processingTimeMS: Int? = null,
        val query: String? = null,
        val params: String? = null)