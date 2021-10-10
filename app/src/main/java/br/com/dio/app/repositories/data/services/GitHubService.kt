package br.com.dio.app.repositories.data.services

import br.com.dio.app.repositories.data.models.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String?): List<Repository>
}