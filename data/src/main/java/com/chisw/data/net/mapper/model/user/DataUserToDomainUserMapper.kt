package com.chisw.data.net.mapper.model.user

import com.chisw.data.net.mapper.Mapper
import com.chisw.data.net.model.user.UserBean
import com.chisw.domain.model.user.UserEntity

class DataUserToDomainUserMapper : Mapper<UserBean, UserEntity> {
    override fun map(from: UserBean): UserEntity {
        val user = UserEntity()
        user.id = from.id
        user.username = from.username
        user.about = from.about
        user.karma = from.karma
        user.createdAt = from.createdAt
        user.avg = from.avg
        user.delay = from.delay
        user.submitted = from.submitted
        user.updatedAt = from.updatedAt
        user.submissionCount = from.submissionCount
        user.commentCount = from.commentCount
        user.createdAtI = from.createdAtI
        user.objectID = from.objectID
        return user
    }
}