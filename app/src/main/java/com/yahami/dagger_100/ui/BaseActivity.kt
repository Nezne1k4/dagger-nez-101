package com.yahami.dagger_100.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yahami.dagger_100.remote.di.component.DaggerApiRepositoryComponent
import com.yahami.dagger_100.remote.di.component.DaggerNetworkComponent
import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.remote.di.module.NetworkModule
import com.yahami.dagger_100.remote.repository.GithubApiRepository
import com.yahami.dagger_100.remote.service.GithubApiService
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var githubApiRepository: GithubApiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // seed here to initialize GithubApiRepository
        DaggerApiRepositoryComponent.builder()
                .networkComponent(DaggerNetworkComponent.builder()
                        .networkModule(NetworkModule())
                        .build())
                .apiRepositoryModule(ApiRepositoryModule())
                .build()
                .inject(this)
    }
}