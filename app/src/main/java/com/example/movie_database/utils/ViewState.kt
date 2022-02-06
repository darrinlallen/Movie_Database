package com.example.movie_database.utils

import com.example.movie_database.model.MovieDataClass

sealed class ViewState {
    object Loading: ViewState()
    data class  Error(val exception: String) : ViewState()
    data class  Success(val movies: MovieDataClass) : ViewState()
}