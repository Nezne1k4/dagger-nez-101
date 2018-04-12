package com.yahami.dagger_100.remote.di.module

import com.yahami.dagger_100.remote.service.GithubApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiRepositoryModule() {

    @Provides
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }

//    @Provides
//    fun provideApplication() = application

//    @Provides
//    fun provideGithubApiRepository(githubApiService: GithubApiService): GithubApiRepository {
//        return GithubApiRepositoryImpl(githubApiService)
//    }

//    @Provides
//    fun provideGithubApiRepository(retrofit: Retrofit): GithubApiRepository {
//        return GithubApiRepositoryImpl(retrofit.create(GithubApiService::class.java))
//    }
}