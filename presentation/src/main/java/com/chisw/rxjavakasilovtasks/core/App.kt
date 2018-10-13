package com.chisw.rxjavakasilovtasks.core

import android.app.Application
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.datasource.task01.TaskOneDataSource
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.mapper.model.*
import com.chisw.data.net.repository.RepositoryImpl
import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.model.story.*

class App : Application() {

    companion object {
        var repository: Repository? = null
    }

    private fun getRepositoryImp(dataSource: DataSource?,
                                 mapper: Mapper<com.chisw.data.net.model.story.Data, Data>): Repository? {
        return RepositoryImpl(dataSource, mapper)
    }

    private fun getDataSource(): DataSource? {
        return TaskOneDataSource()
    }

    private fun getStoryDataModelToDomainModel(hitMapper: Mapper<com.chisw.data.net.model.story.Hit, Hit>): Mapper<com.chisw.data.net.model.story.Data, Data> {
        return StoryDataModelToDomainModelMapper(hitMapper)
    }

    private fun getHitMapper(highlightResultDataModelToDomainModelMapper: Mapper<com.chisw.data.net.model.story.HighlightResult, HighlightResult>): Mapper<com.chisw.data.net.model.story.Hit, Hit> {
        return HitDataModelToDomainMapper(highlightResultDataModelToDomainModelMapper)
    }

    private fun getHighlightModelMapper(titleMapper: Mapper<com.chisw.data.net.model.story.Title, Title>,
                                        authorMapper: Mapper<com.chisw.data.net.model.story.Author, Author>,
                                        urlMapper: Mapper<com.chisw.data.net.model.story.Url, Url>
    ): Mapper<com.chisw.data.net.model.story.HighlightResult, HighlightResult> {
        return HighlightResultDataModelToDomainModelMapper(authorMapper, urlMapper, titleMapper)
    }

    private fun getTitleModelMapper(): Mapper<com.chisw.data.net.model.story.Title, Title> {
        return TitleDataModelToDomainModelMapper()
    }

    private fun getUrlModelMapper(): Mapper<com.chisw.data.net.model.story.Url, Url> {
        return UrlDataModelToDomainModelMapper()
    }

    private fun getAuthorModelMapper(): Mapper<com.chisw.data.net.model.story.Author, Author> {
        return AuthorDataModelToDomainModel()
    }

    override fun onCreate() {
        super.onCreate()
        repository = getRepositoryImp(getDataSource(),
                getStoryDataModelToDomainModel(
                        getHitMapper(
                                getHighlightModelMapper(
                                        getTitleModelMapper(), getAuthorModelMapper(), getUrlModelMapper()))))
    }
}