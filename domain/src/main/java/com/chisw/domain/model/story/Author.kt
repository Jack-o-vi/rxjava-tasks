package com.chisw.domain.model.story

data class Author(var value: String? = null,
                  var matchLevel: String? = null,
                  var matchedWords: MutableList<String>? = null)