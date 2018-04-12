package com.yahami.dagger_100.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: Application)

    //fun inject(baseActivity: BaseActivity)
}