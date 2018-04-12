package com.yahami.dagger_100.remote.di.module

import android.app.Application
import com.yahami.dagger_100._Dagger100Application
import com.yahami.dagger_100.remote.repository.GithubApiRepository
import com.yahami.dagger_100.remote.repository.GithubApiRepositoryImpl
import com.yahami.dagger_100.remote.service.GithubApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiRepositoryModule(val application: Application) {

    @Provides
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }

    @Provides
    fun provideApplication() = application

//    @Provides
//    fun provideGithubApiRepository(githubApiService: GithubApiService): GithubApiRepository {
//        return GithubApiRepositoryImpl(githubApiService)
//    }

//    @Provides
//    fun provideGithubApiRepository(retrofit: Retrofit): GithubApiRepository {
//        return GithubApiRepositoryImpl(retrofit.create(GithubApiService::class.java))
//    }
}