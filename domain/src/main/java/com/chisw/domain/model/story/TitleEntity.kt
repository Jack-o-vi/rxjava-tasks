package com.chisw.domain.model.story

data class TitleEntity(var value: String? = null,
                       var matchLevel: String? = null,
                       var matchedWords: MutableList<Any>? = null)