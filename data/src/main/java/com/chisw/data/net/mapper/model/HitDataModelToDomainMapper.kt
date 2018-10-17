package com.chisw.data.net.mapper.model

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.HighlightResult
import com.chisw.data.net.model.story.Hit
import com.chisw.domain.model.story.HighlightResult as DomainHighlightResult
import com.chisw.domain.model.story.Hit as DomainHit

class HitDataModelToDomainMapper(private val highlightResultDataModelToDomainModelMapper: Mapper<HighlightResult, DomainHighlightResult>) : Mapper<Hit, DomainHit> {
    override fun map(from: Hit): DomainHit {
        Log.d("duck", "Mapper hit $from")
        val hit = DomainHit()
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
