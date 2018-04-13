package com.yahami.dagger_100.remote.repository

import com.yahami.dagger_100.remote.di.ApiServiceScope
import com.yahami.dagger_100.remote.model.Repository
import com.yahami.dagger_100.remote.model.User
import com.yahami.dagger_100.remote.service.GithubApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Key point here, now GithubApiRepositoryImpl is singleton
 */
@Singleton
class GithubApiRepositoryImpl private constructor() : GithubApiRepository {

    private lateinit var apiService: GithubApiService

    /**
     * Key point here, we inject the GithubApiRepositoryImpl with dependency of GithubApiService
     * so that GithubApiRepositoryImpl will be injected in ApiRepositoryModule::provideGithubApiRepository
     *
     * This is a sample of injection method
     */
    @Inject
    constructor(api: GithubApiService) : this() {
        apiService = api
    }

    override fun getUser(username: String): Single<User> {
        return apiService.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { User(it) }
    }

    override fun getUsersRepositories(username: String): Single<MutableList<Repository>> {
        return apiService.getUsersRepositories(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    val results: MutableList<Repository> = mutableListOf()
                    it.forEach { results.add(Repository(it)) }
                    results
                }
    }

//  This static call is replaced by dagger implementation
//    companion object {
//        fun get() : GithubApiRepository {
//            return GithubApiRepositoryImpl(retrofit.create(GithubApiService::class.java))
//        }
//    }
}