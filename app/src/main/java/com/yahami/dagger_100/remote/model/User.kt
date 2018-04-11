package com.yahami.dagger_100.remote.model

import android.os.Parcelable
import com.yahami.dagger_100.remote.dto.UserResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val id: Long,
           val url: String,
           val login: String,
           val email: String
) : Parcelable {
    constructor(userResponse: UserResponse) : this(
            id = userResponse.id ?: 0,
            url = userResponse.url ?: "",
            login = userResponse.login ?: "",
            email = userResponse.email ?: ""
            )
}
