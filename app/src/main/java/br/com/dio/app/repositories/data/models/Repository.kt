package br.com.dio.app.repositories.data.models

import com.google.gson.annotations.SerializedName

data class Repository(
        val id: Long,
        val name: String,
        val owner: Owner,
        @SerializedName("stargazed_count")
        val stargazedCount: Long,
        val language: String,
        @SerializedName("html_url")
        val htmlURL: String,
        val description: String

)
