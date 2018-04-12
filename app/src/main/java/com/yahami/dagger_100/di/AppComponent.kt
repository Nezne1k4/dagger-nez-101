package com.yahami.dagger_100.di

import android.app.Application
import com.yahami.dagger_100.remote.di.component.ApiRepositoryComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: Application)
}