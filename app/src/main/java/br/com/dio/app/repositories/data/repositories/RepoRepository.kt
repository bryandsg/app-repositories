package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.models.Repository
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(name: String): Flow<List<Repository>>
}