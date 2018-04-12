package com.yahami.dagger_100

import android.app.Application
import android.content.res.Resources
import android.util.Log
import com.yahami.dagger_100.di.AppComponent
import com.yahami.dagger_100.di.AppModule
import com.yahami.dagger_100.di.DaggerAppComponent
import javax.inject.Inject
import javax.inject.Named

class _Dagger100Application : Application() {

    @Inject
    lateinit var res: Resources

    @field:[Inject Named("something")]
    lateinit var something: String

    @field:[Inject Named("somethingElse")]
    lateinit var somethingElse: String

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        // seed the dependency
        resolveDependencies()

        super.onCreate()

        // use the di, why does not work?
        //Log.i("use the di", "$something $somethingElse ${res.getString(R.string.app_name)}")
    }

    private fun resolveDependencies() {
        graph = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        // seed the graph to initialize objects in module
        graph.inject(this)
    }

}
