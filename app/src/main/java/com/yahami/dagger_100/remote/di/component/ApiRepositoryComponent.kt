package com.yahami.dagger_100.remote.di.component

import com.yahami.dagger_100.remote.di.module.ApiRepositoryModule
import com.yahami.dagger_100.ui.BaseActivity
import com.yahami.dagger_100.ui.MainActivity
import dagger.Component

//@Component(modules = [ApiRepositoryModule::class])
@Component(modules = [ApiRepositoryModule::class],
        dependencies = [NetworkComponent::class])
interface ApiRepositoryComponent {

//    fun inject(mainActivity: MainActivity) // -> work

    fun inject(baseActivity: BaseActivity) // -> not work
}