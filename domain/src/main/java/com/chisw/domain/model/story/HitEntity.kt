package com.chisw.domain.model.story

data class HitEntity constructor(
        var title: String? = null,
        var url: String? = null,
        var author: String? = null,
        var points: Int? = null,
        var storyText: Any? = null,
        var commentText: Any? = null,
        var tags: MutableList<String>? = null,
        var numComments: Int? = null,
        var objectID: String? = null,
        var highlightResult: HighlightResultEntity? = null)