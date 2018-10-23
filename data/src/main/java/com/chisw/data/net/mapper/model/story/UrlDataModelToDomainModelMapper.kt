package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.UrlBean
import com.chisw.domain.model.story.UrlEntity

class UrlDataModelToDomainModelMapper : Mapper<UrlBean, UrlEntity> {
    override fun map(from: UrlBean): UrlEntity {
        Log.d("duck", "Mapper url $from")
        val url = UrlEntity()
        url.value = from.value
        url.matchLevel = from.matchLevel
        url.matchedWords = from.matchedWords
        return url
    }
}