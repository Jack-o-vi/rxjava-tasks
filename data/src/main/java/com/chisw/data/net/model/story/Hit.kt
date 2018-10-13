package com.chisw.data.net.model.story

import com.google.gson.annotations.SerializedName

data class Hit constructor(
        val title: String? = null,
        val url: String? = null,
        val author: String? = null,
        val points: Int? = null,
        @SerializedName("story_text")
        val storyText: Any? = null,
        @SerializedName("comment_text")
        val commentText: Any? = null,
        @SerializedName("_tags")
        val tags: List<String>? = null,
        @SerializedName("num_comments")
        val numComments: Int? = null,
        val objectID: String? = null,
        @SerializedName("_highlightResult")
        val highlightResult: HighlightResult? = null) {


}