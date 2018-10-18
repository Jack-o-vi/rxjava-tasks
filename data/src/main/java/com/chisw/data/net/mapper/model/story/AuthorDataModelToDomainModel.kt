package com.chisw.data.net.mapper.model.story

import android.util.Log
import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.story.Author
import com.chisw.domain.model.story.Author as DomainAuthor

class AuthorDataModelToDomainModel : Mapper<Author, DomainAuthor> {
    override fun map(from: Author): DomainAuthor {
        Log.d("duck", "Mapper author $from")
        val author = DomainAuthor()
        author.matchLevel = from.matchLevel
        author.matchedWords = from.matchedWords
        author.value = from.value
        return author
    }
}