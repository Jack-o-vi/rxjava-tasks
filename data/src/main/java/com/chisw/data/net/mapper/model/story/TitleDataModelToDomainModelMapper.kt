package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Title
import com.chisw.domain.model.story.Title as DomainTitle

class TitleDataModelToDomainModelMapper : Mapper<Title, DomainTitle> {
    override fun map(from: Title): DomainTitle {
        Log.d("duck", "Mapper data $from")
        val title = DomainTitle()
        title.matchLevel = from.matchLevel
        title.matchedWords = from.matchedWords
        title.value = from.value
        return title
    }
}