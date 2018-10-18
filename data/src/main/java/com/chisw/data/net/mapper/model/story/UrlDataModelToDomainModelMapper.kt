package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Url
import com.chisw.domain.model.story.Url as DomainUrl

class UrlDataModelToDomainModelMapper : Mapper<Url, DomainUrl> {
    override fun map(from: Url): DomainUrl {
        Log.d("duck", "Mapper url $from")
        val url = DomainUrl()
        url.value = from.value
        url.matchLevel = from.matchLevel
        url.matchedWords = from.matchedWords
        return url
    }
}