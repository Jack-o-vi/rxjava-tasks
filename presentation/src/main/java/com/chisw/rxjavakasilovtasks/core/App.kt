package com.chisw.rxjavakasilovtasks.core

import android.app.Application
import com.chisw.data.net.datasource.DataSource
import com.chisw.data.net.datasource.task01.TaskOneDataSource
import com.chisw.data.net.datasource.task02.TaskTwoDataSource
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.mapper.model.story.*
import com.chisw.data.net.mapper.model.user.DataUserToDomainUserMapper
import com.chisw.data.net.model.story.*
import com.chisw.data.net.model.user.UserBean
import com.chisw.data.net.repository.RepositoryImpl
import com.chisw.domain.abstraction.repository.Repository
import com.chisw.domain.model.story.*
import com.chisw.domain.model.user.UserEntity

class App : Application() {

    companion object {
        lateinit var repository: Repository
    }

    private fun getRepositoryImp(dataSource: DataSource<DataBean>,
                                 userDataSource: DataSource<UserBean>,
                                 mapper: Mapper<DataBean, DataEntity>,
                                 userMapper: Mapper<UserBean, UserEntity>): Repository {
        return RepositoryImpl(dataSource, userDataSource, mapper, userMapper)
    }

    private fun getDataSource(): DataSource<DataBean> {
        return TaskOneDataSource()
    }

    private fun getUserDataSource(): DataSource<UserBean> {
        return TaskTwoDataSource()
    }

    private fun getStoryDataModelToDomainModel(hitMapper: Mapper<HitBean, HitEntity>): Mapper<DataBean, DataEntity> {
        return StoryDataModelToDomainModelMapper(hitMapper)
    }

    private fun getHitMapper(highlightResultDataModelToDomainModelMapper: Mapper<HighlightResultBean, HighlightResultEntity>): Mapper<HitBean, HitEntity> {
        return HitDataModelToDomainMapper(highlightResultDataModelToDomainModelMapper)
    }

    private fun getHighlightModelMapper(titleMapper: Mapper<TitleBean, TitleEntity>,
                                        authorMapper: Mapper<AuthorBean, AuthorEntity>,
                                        urlMapper: Mapper<UrlBean, UrlEntity>
    ): Mapper<HighlightResultBean, HighlightResultEntity> {
        return HighlightResultDataModelToDomainModelMapper(authorMapper, urlMapper, titleMapper)
    }

    private fun getTitleModelMapper(): Mapper<TitleBean, TitleEntity> {
        return TitleDataModelToDomainModelMapper()
    }

    private fun getUrlModelMapper(): Mapper<UrlBean, UrlEntity> {
        return UrlDataModelToDomainModelMapper()
    }

    private fun getAuthorModelMapper(): Mapper<AuthorBean, AuthorEntity> {
        return AuthorDataModelToDomainModel()
    }

    private fun getUserModelMapper(): Mapper<UserBean, UserEntity> {
        return DataUserToDomainUserMapper()
    }

    override fun onCreate() {
        super.onCreate()
        repository = getRepositoryImp(getDataSource(),
                getUserDataSource(),
                getStoryDataModelToDomainModel(
                        getHitMapper(
                                getHighlightModelMapper(
                                        getTitleModelMapper(), getAuthorModelMapper(), getUrlModelMapper()))),
                getUserModelMapper())
    }
}