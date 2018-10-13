package com.chisw.domain.model.story

data class Hit constructor(
        var title: String? = null,
        var url: String? = null,
        var author: String? = null,
        var points: Int? = null,
        var storyText: Any? = null,
        var commentText: Any? = null,
        var tags: List<String>? = null,
        var numComments: Int? = null,
        var objectID: String? = null,
        var highlightResult: HighlightResult? = null) {


}