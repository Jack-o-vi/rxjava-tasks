package com.chisw.domain.model.story

data class DataEntity(
        var hits: MutableList<HitEntity>? = null,
        var page: Int? = null,
        var nbHits: Int? = null,
        var nbPages: Int? = null,
        var hitsPerPage: Int? = null,
        var processingTimeMS: Int? = null,
        var query: String? = null,
        var params: String? = null)