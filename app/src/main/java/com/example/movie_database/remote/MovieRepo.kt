package com.example.movie_database.remote


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieRepo {
    private val movieService by lazy { RetrofitInstance().movieService }

    suspend fun getMovie(name : String) = withContext(Dispatchers.IO) {
        movieService.getMovies(name)
    }

}