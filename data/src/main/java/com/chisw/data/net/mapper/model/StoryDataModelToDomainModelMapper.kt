package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.Data
import java.util.*

class StoryDataModelToDomainModelMapper(private val hitMapper: Mapper<com.chisw.data.net.model.story.Hit, com.chisw.domain.model.story.Hit>) : Mapper<com.chisw.data.net.model.story.Data, Data> {
    override fun map(from: com.chisw.data.net.model.story.Data): Data {
        val data = Data()
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