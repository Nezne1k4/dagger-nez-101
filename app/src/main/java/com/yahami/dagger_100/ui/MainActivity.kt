package com.yahami.dagger_100.ui

import android.os.Bundle
import com.yahami.dagger_100.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // must seed where objects are used, in this case are res, something, somethingElse
        //_Dagger100Application.appComponent.inject(this)

        viewButton.setOnClickListener {
            githubApiRepository.getUser(viewEtUsername.text.toString())
                    .subscribe(
                            { viewTextview.text = it.toString() },
                            { viewTextview.text = it.message }
                    )
        }
    }
}
