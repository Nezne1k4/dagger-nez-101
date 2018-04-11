package com.yahami.dagger_100.remote.service

import com.yahami.dagger_100.remote.dto.RepositoryResponse
import com.yahami.dagger_100.remote.dto.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("/users/{username}")
    fun getUser(
            @Path("username") username: String
    ): Single<UserResponse>

    @GET("/users/{username}/repos")
    fun getUsersRepositories(
            @Path("username") username: String
    ): Single<List<RepositoryResponse>>
}
