package com.example.movie_database.remote


import android.util.Log
import com.example.movie_database.databinding.SearchFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieRepo {
    private val movieService by lazy { RetrofitInstance().movieService }


    suspend fun getMovie(name: String) = withContext(Dispatchers.IO) {
        movieService.getMovies(name)
    }

}