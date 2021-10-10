package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImplementation(private val service: GitHubService): RepoRepository {
    override suspend fun listRepositories(name: String) = flow {

        try {
            val repositoryList = service.listRepositories(name)
            emit(repositoryList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel realizar a pesquisa, tente novamente mais tarde.")
        }

    }
}