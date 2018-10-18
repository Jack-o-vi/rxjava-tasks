package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Author
import com.chisw.data.net.model.story.HighlightResult
import com.chisw.data.net.model.story.Title
import com.chisw.data.net.model.story.Url
import com.chisw.domain.model.story.Author as DomainAuthor
import com.chisw.domain.model.story.HighlightResult as DomainHighlightResult
import com.chisw.domain.model.story.Title as DomainTitle
import com.chisw.domain.model.story.Url as DomainUrl

class HighlightResultDataModelToDomainModelMapper(private val authorMapper: Mapper<Author, DomainAuthor>,
                                                  private val urlMapper: Mapper<Url, DomainUrl>,
                                                  private val titleMapper: Mapper<Title, DomainTitle>) : Mapper<HighlightResult, DomainHighlightResult> {
    override fun map(from: com.chisw.data.net.model.story.HighlightResult): DomainHighlightResult {
        Log.d("duck", "Mapper highlight $from")
        val highlightResult = DomainHighlightResult()
        from.apply {
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
        return highlightResult
    }
}