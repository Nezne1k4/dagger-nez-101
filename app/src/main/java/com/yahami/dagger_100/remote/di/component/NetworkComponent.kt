package com.yahami.dagger_100.remote.di.component

import com.yahami.dagger_100.remote.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {

    /**
     * The target is creating a Retrofit instance, which is used in ApiRepositoryModule
     */
    fun retrofit(): Retrofit
}