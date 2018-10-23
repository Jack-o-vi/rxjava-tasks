package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.TitleBean
import com.chisw.domain.model.story.TitleEntity

class TitleDataModelToDomainModelMapper : Mapper<TitleBean, TitleEntity> {
    override fun map(from: TitleBean): TitleEntity {
        Log.d("duck", "Mapper data $from")
        val title = TitleEntity()
        title.matchLevel = from.matchLevel
        title.matchedWords = from.matchedWords
        title.value = from.value
        return title
    }
}