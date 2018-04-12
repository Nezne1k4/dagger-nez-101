package com.yahami.dagger_100.remote.model

import android.os.Parcelable
import com.yahami.dagger_100.remote.dto.RepositoryResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(val id: Long,
                      val name: String,
                      val url: String
) : Parcelable {
    constructor(repo: RepositoryResponse) : this(
            id = repo.id ?: 0,
            name = repo.name ?: "",
            url = repo.url ?: ""
    )
}
