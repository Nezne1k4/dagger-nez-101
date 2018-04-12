package com.yahami.dagger_100.remote.di.component

import com.yahami.dagger_100.remote.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun retrofit(): Retrofit
}