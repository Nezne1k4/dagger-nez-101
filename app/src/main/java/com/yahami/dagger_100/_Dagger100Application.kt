package com.yahami.dagger_100

import android.app.Application
import com.yahami.dagger_100.di.AppComponent
import com.yahami.dagger_100.di.AppModule
import com.yahami.dagger_100.di.DaggerAppComponent

class _Dagger100Application : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var application: Application
    }

    override fun onCreate() {
        // seed the dependency
        resolveDependencies()

        super.onCreate()
    }

    private fun resolveDependencies() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        // seed the graph to initialize objects in module
        appComponent.inject(this)

        application = this

    }

}
