package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.AuthorBean
import com.chisw.domain.model.story.AuthorEntity

class AuthorDataModelToDomainModel : Mapper<AuthorBean, AuthorEntity> {
    override fun map(from: AuthorBean): AuthorEntity {
        Log.d("duck", "Mapper author $from")
        val author = AuthorEntity()
        author.matchLevel = from.matchLevel
        author.matchedWords = from.matchedWords
        author.value = from.value
        return author
    }
}