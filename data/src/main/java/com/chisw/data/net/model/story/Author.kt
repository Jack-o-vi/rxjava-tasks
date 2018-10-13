package com.chisw.data.net.model.story

data class Author (val value: String? = null,
                              val matchLevel: String? = null,
                              val matchedWords: MutableList<String>? = null)