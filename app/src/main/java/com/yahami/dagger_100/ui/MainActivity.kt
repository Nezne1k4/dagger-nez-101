package com.yahami.dagger_100.ui

import android.os.Bundle
import com.yahami.dagger_100.R
import com.yahami.dagger_100._Dagger100Application
import com.yahami.dagger_100.remote.repository.GithubApiRepository
import com.yahami.dagger_100.remote.repository.GithubApiRepositoryImpl
import com.yahami.dagger_100.remote.service.GithubApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

//    @Inject
//    lateinit var res : Resources
//
//    @field:[Inject Named("something")]
//    lateinit var something: String
//
//    @field:[Inject Named("somethingElse")]
//    lateinit var somethingElse: String

//    @Inject
//    lateinit var githubApiRepository: GithubApiRepository

    @Inject
    lateinit var apiService: GithubApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // seed the dagger
        //_Dagger100Application.graph.inject(this)

//        val networkComponent = DaggerNetworkComponent.builder()
//                .networkModule(NetworkModule())
//                .apiRepositoryComponent()
//                .build()

//        val apiComponent = DaggerApiRepositoryComponent.builder()
//                .networkComponent(networkComponent)
//                .apiRepositoryModule(ApiRepositoryModule())
//                .build()

        _Dagger100Application.apiComponent.inject(this)

        viewButton.setOnClickListener {
//            GithubApiRepositoryImpl.get().getUser(viewEtUsername.text.toString())
//                    .subscribe(
//                            { viewTextview.text = it.toString() },
//                            { viewTextview.text = it.message }
//                    )

//            GithubApiRepositoryImpl.get().getUsersRepositories(viewEtUsername.text.toString())
//                    .subscribe(
//                            { viewTextview.text = it.toString() },
//                            { viewTextview.text = it.message }
//                    )

            apiService.getUsersRepositories(viewEtUsername.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { viewTextview.text = it.toString() },
                            { viewTextview.text = it.message }
                    )
        }

//        viewTextview.text = something + somethingElse + res.getString(R.string.app_name)
    }
}
