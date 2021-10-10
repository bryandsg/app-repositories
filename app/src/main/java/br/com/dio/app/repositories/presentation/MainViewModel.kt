package br.com.dio.app.repositories.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dio.app.repositories.data.models.Repository
import br.com.dio.app.repositories.domain.ListUserRepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(

    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
    ): ViewModel() {
    private val _repository = MutableLiveData<State>()
    val repository: LiveData<State> = _repository

    fun getListRepositories(user: String) {
        viewModelScope.launch {
            listUserRepositoriesUseCase(user)
                    .onStart {
                        _repository.postValue(State.Loading)
                    }
                    .catch {
                        _repository.postValue(State.Error(it))
                    }
                    .collect {
                        _repository.postValue(State.Success(it))
                    }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val list: List<Repository>): State()
        data class  Error(val error: Throwable): State()
    }
}