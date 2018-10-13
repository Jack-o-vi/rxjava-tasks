package com.chisw.domain.model.story

data class Title(var value: String? = null,
                 var matchLevel: String? = null,
                 var matchedWords: MutableList<Any>? = null)