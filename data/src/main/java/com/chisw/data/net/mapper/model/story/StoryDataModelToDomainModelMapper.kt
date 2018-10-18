package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Data
import com.chisw.data.net.model.story.Hit
import java.util.*
import com.chisw.domain.model.story.Data as DomainData
import com.chisw.domain.model.story.Hit as DomainHit

class StoryDataModelToDomainModelMapper(private val hitMapper: Mapper<Hit, DomainHit>) : Mapper<Data, DomainData> {
    override fun map(from: Data): DomainData {
        Log.d("duck", "Mapper data $from")
        val data = DomainData()
        val listHit = from.hits
        val listDomainHit: MutableList<com.chisw.domain.model.story.Hit> = LinkedList()
        listHit?.let {
            for (item in it) {
                listDomainHit.add(hitMapper.map(item))
            }
        }
        data.hits = listDomainHit
        data.hitsPerPage = from.hitsPerPage
        data.nbHits = from.nbHits
        data.nbPages = from.nbPages
        data.page = from.page
        data.params = from.params
        data.processingTimeMS = from.processingTimeMS
        data.query = from.query
        return data
    }
}