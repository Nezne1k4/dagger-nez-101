package com.yahami.dagger_100.remote.di.component

import com.yahami.dagger_100.remote.di.ApiServiceScope
import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApiRepositoryModule::class],
        dependencies = [NetworkComponent::class])
//@Singleton
@ApiServiceScope
interface ApiRepositoryComponent {

//    fun inject(mainActivity: MainActivity) // inject sub class is different from superclass

    fun inject(baseActivity: BaseActivity)
}