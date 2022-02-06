package com.example.movie_database.viewmodel

import androidx.lifecycle.*
import com.example.movie_database.remote.MovieRepo
import com.example.movie_database.utils.ViewState
import kotlinx.coroutines.launch


class MovieViewModel(state: SavedStateHandle) : ViewModel() {
    val title = state.get<String>("name")
    private val _viewState = MutableLiveData<ViewState>(ViewState.Loading)
    val viewState: LiveData<ViewState> get() = _viewState


    init {
        viewModelScope.launch {
            val state = try {

                val movies = MovieRepo.getMovie(title.toString())
                ViewState.Success(movies)
            } catch (ex: Exception) {
                ViewState.Error(ex.message ?: "Something went wrong")

            }
            _viewState.value = state

        }
    }

}
