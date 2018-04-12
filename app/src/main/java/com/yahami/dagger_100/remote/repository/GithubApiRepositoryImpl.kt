package com.yahami.dagger_100.remote.repository

import com.yahami.dagger_100.remote.model.Repository
import com.yahami.dagger_100.remote.model.User
import com.yahami.dagger_100.remote.service.GithubApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubApiRepositoryImpl(val api: GithubApiService) : GithubApiRepository {

    override fun getUser(username: String): Single<User> {
        return api.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { User(it) }
    }

    override fun getUsersRepositories(username: String): Single<MutableList<Repository>> {
        return api.getUsersRepositories(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    val results: MutableList<Repository> = mutableListOf()
                    it.forEach { results.add(Repository(it)) }
                    results
                }
    }

//    companion object {
//        fun get() : GithubApiRepository {
//            return GithubApiRepositoryImpl(retrofit.create(GithubApiService::class.java))
//        }
//    }
}