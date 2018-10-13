package com.chisw.domain.model.story

data class Url(var value: String? = null,
               var matchLevel: String? = null,
               var matchedWords: MutableList<Any>? = null)