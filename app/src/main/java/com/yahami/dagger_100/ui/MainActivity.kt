package com.yahami.dagger_100.ui

import android.content.res.Resources
import android.os.Bundle
import com.yahami.dagger_100.R
import com.yahami.dagger_100._Dagger100Application
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity() {

    @Inject
    lateinit var res: Resources

    @field:[Inject Named("something")]
    lateinit var something: String

    @field:[Inject Named("somethingElse")]
    lateinit var somethingElse: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // must seed where objects are used, in this case are res, something, somethingElse
        _Dagger100Application.appComponent.inject(_Dagger100Application.application)

        viewTextview.text = something + somethingElse + res.getString(R.string.app_name)

        viewButton.setOnClickListener {
            githubApiRepository.getUser(viewEtUsername.text.toString())
                    .subscribe(
                            { viewTextview.text = it.toString() },
                            { viewTextview.text = it.message }
                    )
        }
    }
}
