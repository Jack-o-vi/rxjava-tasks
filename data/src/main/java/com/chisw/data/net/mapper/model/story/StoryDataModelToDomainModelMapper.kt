package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.DataBean
import com.chisw.data.net.model.story.HitBean
import com.chisw.domain.model.story.DataEntity
import com.chisw.domain.model.story.HitEntity
import java.util.*

class StoryDataModelToDomainModelMapper(private val hitMapper: Mapper<HitBean, HitEntity>) : Mapper<DataBean, DataEntity> {
    override fun map(from: DataBean): DataEntity {
        Log.d("duck", "Mapper data $from")
        val data = DataEntity()
        val listHit = from.hits
        val listDomainHit: MutableList<com.chisw.domain.model.story.HitEntity> = LinkedList()
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