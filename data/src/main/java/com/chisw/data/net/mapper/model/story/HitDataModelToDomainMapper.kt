package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.HighlightResultBean
import com.chisw.data.net.model.story.HitBean
import com.chisw.domain.model.story.HighlightResultEntity
import com.chisw.domain.model.story.HitEntity

class HitDataModelToDomainMapper(private val highlightResultDataModelToDomainModelMapper:
                                 Mapper<HighlightResultBean, HighlightResultEntity>) : Mapper<HitBean, HitEntity> {
    override fun map(from: HitBean): HitEntity {
        Log.d("duck", "Mapper hit $from")
        val hit = HitEntity()
        hit.author = from.author
        hit.commentText = from.commentText
        hit.numComments = from.numComments
        from.highlightResult?.also {
            hit.highlightResult = highlightResultDataModelToDomainModelMapper.map(it)
        }
        hit.objectID = from.objectID
        hit.points = from.points
        hit.storyText = from.storyText
        hit.tags = from.tags
        hit.title = from.title
        hit.url = from.url
        return hit
    }
}
