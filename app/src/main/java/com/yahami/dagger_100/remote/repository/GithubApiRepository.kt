package com.yahami.dagger_100.remote.repository

import com.yahami.dagger_100.remote.model.Repository
import com.yahami.dagger_100.remote.model.User
import io.reactivex.Single

interface GithubApiRepository {

    fun getUser(username: String): Single<User>

    fun getUsersRepositories(username: String): Single<MutableList<Repository>>
}