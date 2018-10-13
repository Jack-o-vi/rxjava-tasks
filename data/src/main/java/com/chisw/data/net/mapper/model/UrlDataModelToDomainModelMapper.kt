package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.Url

class UrlDataModelToDomainModelMapper : Mapper<com.chisw.data.net.model.story.Url, Url> {
    override fun map(from: com.chisw.data.net.model.story.Url): Url {
        val url = Url()
        url.value = from.value
        url.matchLevel = from.matchLevel
        url.matchedWords = from.matchedWords
        return url
    }
}