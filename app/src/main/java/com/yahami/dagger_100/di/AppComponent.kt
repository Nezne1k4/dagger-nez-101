package com.yahami.dagger_100.di

import android.app.Application
import com.yahami.dagger_100.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: Application)

    //fun inject(mainActivity: MainActivity)
}