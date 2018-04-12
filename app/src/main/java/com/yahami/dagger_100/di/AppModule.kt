package com.yahami.dagger_100.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    //@ForApplication
    fun provideApplicationContext(): Context = application

    @Provides
    fun provideApplication(): Application? {
        return application
    }

    @Provides
    @Singleton
    fun provideLocationManager(): LocationManager =
            application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    fun provideResources(): Resources {
        return application.resources
    }

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String = "something"

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String = "somethingElse"
}