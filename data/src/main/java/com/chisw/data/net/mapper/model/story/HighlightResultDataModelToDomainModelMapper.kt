package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.AuthorBean
import com.chisw.data.net.model.story.HighlightResultBean
import com.chisw.data.net.model.story.TitleBean
import com.chisw.data.net.model.story.UrlBean
import com.chisw.domain.model.story.AuthorEntity
import com.chisw.domain.model.story.HighlightResultEntity
import com.chisw.domain.model.story.TitleEntity
import com.chisw.domain.model.story.UrlEntity

class HighlightResultDataModelToDomainModelMapper(private val authorMapper: Mapper<AuthorBean, AuthorEntity>,
                                                  private val urlMapper: Mapper<UrlBean, UrlEntity>,
                                                  private val titleMapper: Mapper<TitleBean, TitleEntity>) : Mapper<HighlightResultBean, HighlightResultEntity> {
    override fun map(from: com.chisw.data.net.model.story.HighlightResultBean): HighlightResultEntity {
        Log.d("duck", "Mapper highlight $from")
        val highlightResult = HighlightResultEntity()
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