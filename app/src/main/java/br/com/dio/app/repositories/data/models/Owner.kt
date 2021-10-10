package br.com.dio.app.repositories.data.models

import com.google.gson.annotations.SerializedName

data class Owner(
        val login: String,
        @SerializedName("avatar_url")
        val avatarURL: String
)
