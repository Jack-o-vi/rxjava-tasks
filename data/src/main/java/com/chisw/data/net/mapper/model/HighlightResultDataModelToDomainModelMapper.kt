package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.Author
import com.chisw.domain.model.story.HighlightResult
import com.chisw.domain.model.story.Title
import com.chisw.domain.model.story.Url

class HighlightResultDataModelToDomainModelMapper(private val authorMapper: Mapper<com.chisw.data.net.model.story.Author, Author>,
                                                  private val urlMapper: Mapper<com.chisw.data.net.model.story.Url, Url>,
                                                  private val titleMapper: Mapper<com.chisw.data.net.model.story.Title, Title>) : Mapper<com.chisw.data.net.model.story.HighlightResult, HighlightResult> {
    override fun map(from: com.chisw.data.net.model.story.HighlightResult): HighlightResult {
        val highlightResult = HighlightResult()
        with(from) {
            author?.let { author ->
                highlightResult.author = authorMapper.map(author)
            }
            title?.let { title ->
                highlightResult.title = titleMapper.map(title)
            }
            url?.let { url ->
                highlightResult.url = urlMapper.map(url)
            }
        }
//        highlightResult.author = authorMapper.map(from.author!!)
//        highlightResult.title = titleMapper.map(from.title!!)
//        highlightResult.url = urlMapper.map(from.url!!)
        return highlightResult
    }
}