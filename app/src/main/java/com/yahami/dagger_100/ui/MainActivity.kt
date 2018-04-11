package com.yahami.dagger_100.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yahami.dagger_100.R
import com.yahami.dagger_100.remote.repository.GithubApiRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewButton.setOnClickListener {
            GithubApiRepositoryImpl.get().getUser(viewEtUsername.text.toString())
                    .subscribe(
                            { viewTextview.text = it.toString() },
                            { viewTextview.text = it.message }
                    )
        }
    }
}
