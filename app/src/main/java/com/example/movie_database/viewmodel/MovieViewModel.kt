package com.example.movie_database.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_database.remote.MovieRepo
import com.example.movie_database.utils.ViewState
import kotlinx.coroutines.launch
import java.lang.Exception


class MovieViewModel : ViewModel() {
    private val _viewState = MutableLiveData<ViewState>(ViewState.Loading)
    val viewState: LiveData<ViewState> get() = _viewState

    init {
        viewModelScope.launch {
            val state = try {

                val movies = MovieRepo.getMovie("karate")
                ViewState.Success(movies)
            } catch (ex: Exception) {
                ViewState.Error(ex.message ?: "Something went wrong")

            }
            _viewState.value = state

        }
    }


    fun getMovieName(movieName: String) = viewModelScope.launch {

        val state = try {

            val movies = MovieRepo.getMovie()
            ViewState.Success(movies)
        } catch (ex: Exception) {
            ViewState.Error(ex.message ?: "Something went wrong")

        }
        _viewState.value = state
    }

}
