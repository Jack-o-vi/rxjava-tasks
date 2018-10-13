package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.Title

class TitleDataModelToDomainModelMapper : Mapper<com.chisw.data.net.model.story.Title, Title> {
    override fun map(from: com.chisw.data.net.model.story.Title): Title {
        val title = Title()
        title.matchLevel = from.matchLevel
        title.matchedWords = from.matchedWords
        title.value = from.value
        return title
    }
}