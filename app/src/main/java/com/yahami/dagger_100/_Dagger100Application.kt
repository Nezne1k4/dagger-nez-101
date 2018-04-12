package com.yahami.dagger_100

import android.app.Application
import com.yahami.dagger_100.di.AppComponent
import com.yahami.dagger_100.di.AppModule
import com.yahami.dagger_100.di.DaggerAppComponent
import com.yahami.dagger_100.remote.di.component.ApiRepositoryComponent
import com.yahami.dagger_100.remote.di.component.DaggerApiRepositoryComponent
import com.yahami.dagger_100.remote.di.component.DaggerNetworkComponent
import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.remote.di.module.NetworkModule

class _Dagger100Application : Application() {

    companion object {
        lateinit var graph: AppComponent

        lateinit var apiComponent: ApiRepositoryComponent
    }

    override fun onCreate() {
        resolveDependencies()

        super.onCreate()

        graph = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        graph.inject(this)
    }

    fun resolveDependencies() {
        val networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule())
                .build()

        apiComponent = DaggerApiRepositoryComponent.builder()
                .networkComponent(networkComponent)
                .apiRepositoryModule(ApiRepositoryModule(this))
                .build()
    }

}
