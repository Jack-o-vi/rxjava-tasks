package com.chisw.data.net.mapper.model

import com.chisw.data.net.mapper.Mapper
import com.chisw.domain.model.story.Author

class AuthorDataModelToDomainModel : Mapper<com.chisw.data.net.model.story.Author, Author> {
    override fun map(from: com.chisw.data.net.model.story.Author): Author {
        val author = Author()
        author.matchLevel = from.matchLevel
        author.matchedWords = from.matchedWords
        author.value = from.value
        return author
    }
}