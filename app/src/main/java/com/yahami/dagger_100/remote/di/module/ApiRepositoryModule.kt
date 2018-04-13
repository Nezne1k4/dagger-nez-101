package com.yahami.dagger_100.remote.di.module

import com.yahami.dagger_100.remote.repository.GithubApiRepository
import com.yahami.dagger_100.remote.repository.GithubApiRepositoryImpl
import com.yahami.dagger_100.remote.service.GithubApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiRepositoryModule {

    /**
     * The dependency factor GithubApiService
     */
    @Provides
    fun provideGithubApiService(retrofit: Retrofit): GithubApiService {
        return retrofit.create(GithubApiService::class.java)
    }

    /**
     * The target GithubApiRepository
     * This is the old wat not implementing @Singleton
     */
//    @Provides
//    fun provideGithubApiRepository(githubApiService: GithubApiService): GithubApiRepository {
//        return GithubApiRepositoryImpl(githubApiService)
//    }

    /**
     * The target GithubApiRepository
     * Use @Singleton, with help of GithubApiRepositoryImpl constructor as a Singleton either
     * GithubApiRepositoryImpl is injected in GithubApiRepositoryImpl::constructor method
     *
     * This follow https://medium.com/@Zhuinden/that-missing-guide-how-to-use-dagger2-ef116fbea97
     * check ServiceModule session, not exactly, but that's the way of implementation
     */
    @Provides
    @Singleton
    fun provideGithubApiRepository(githubApiRepositoryImpl: GithubApiRepositoryImpl): GithubApiRepository {
        return githubApiRepositoryImpl
    }
}