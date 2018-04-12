package com.yahami.dagger_100.ui

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yahami.dagger_100._Dagger100Application
import com.yahami.dagger_100.remote.di.component.DaggerApiRepositoryComponent
import com.yahami.dagger_100.remote.di.component.DaggerNetworkComponent
import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.remote.di.module.NetworkModule
import com.yahami.dagger_100.remote.repository.GithubApiRepository
import com.yahami.dagger_100.remote.service.GithubApiService
import javax.inject.Inject
import javax.inject.Named

abstract class BaseActivity : AppCompatActivity() {

//    @Inject
//    lateinit var res : Resources
//
//    @field:[Inject Named("something")]
//    lateinit var something: String
//
//    @field:[Inject Named("somethingElse")]
//    lateinit var somethingElse: String

    @Inject
    lateinit var githubApiRepository: GithubApiRepository

    @Inject
    lateinit var apiService: GithubApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // seed the dagger
        //_Dagger100Application.graph.inject(this)

        //_Dagger100Application.apiComponent.inject(this)

//        val networkComponent = DaggerNetworkComponent.builder()
//                .networkModule(NetworkModule())
//                .build()

        DaggerApiRepositoryComponent.builder()
                .networkComponent(DaggerNetworkComponent.builder()
                        .networkModule(NetworkModule())
                        .build())
                .apiRepositoryModule(ApiRepositoryModule())
                .build()
                .inject(this)
    }
}