package com.chisw.data.net.model.user

/*
    username: "pg",
    about: "PG's bio",
    karma: 99999
 */

data class User(private var username: String,
                private var about: String,
                private var karma: Int)