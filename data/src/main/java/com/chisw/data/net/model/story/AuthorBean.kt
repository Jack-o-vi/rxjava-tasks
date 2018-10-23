package com.chisw.data.net.model.story

data class AuthorBean(val value: String? = null,
                      val matchLevel: String? = null,
                      val matchedWords: MutableList<String>? = null)