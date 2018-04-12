package com.yahami.dagger_100.remote.di.component

import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.remote.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

//@Component(modules = [NetworkModule::class], dependencies = [ApiRepositoryComponent::class])
@Component(modules = [ApiRepositoryModule::class, NetworkModule::class])
interface NetworkComponent {

    fun retrofit(): Retrofit
}