package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.HighlightResult
import com.chisw.domain.model.story.Hit

class HitDataModelToDomainMapper(private val highlightResultDataModelToDomainModelMapper: Mapper<com.chisw.data.net.model.story.HighlightResult, HighlightResult>) : Mapper<com.chisw.data.net.model.story.Hit, Hit> {
    override fun map(from: com.chisw.data.net.model.story.Hit): Hit {
        val hit = Hit()
        hit.author = from.author
        hit.commentText = from.commentText
        hit.numComments = from.numComments
        from.highlightResult?.let {
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
