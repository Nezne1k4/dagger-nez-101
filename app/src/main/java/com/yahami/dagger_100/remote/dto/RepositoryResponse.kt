package com.yahami.dagger_100.remote.dto

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(@SerializedName("id") val id: Long,
                              @SerializedName("name") val name: String,
                              @SerializedName("url") val url: String
)